package com.sandraom.reservatuclase.security;

import com.sandraom.reservatuclase.service.CustomUserDetailsService;
import com.sandraom.reservatuclase.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

/**
 * Filtro de autenticación JWT que intercepta cada solicitud HTTP para validar
 * el token JWT y establecer la autenticación en el contexto de seguridad.
 */
@Component
public class JwtFiltroAutenticacion extends OncePerRequestFilter {

    /**
     * Utilidad para manejar operaciones relacionadas con JWT.
     */
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Servicio personalizado para cargar los detalles de los usuarios.
     */
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     * Método principal del filtro que intercepta cada solicitud HTTP.
     *
     * @param request  La solicitud HTTP entrante.
     * @param response La respuesta HTTP saliente.
     * @param chain    La cadena de filtros que permite continuar con el procesamiento.
     * @throws ServletException En caso de error en el procesamiento del filtro.
     * @throws IOException      En caso de error de entrada/salida.
     */
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain)
            throws ServletException, IOException {
        // Obtiene el encabezado de autorización de la solicitud.
        String authorizationHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        // Verifica si el encabezado contiene un token JWT válido.
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Extrae el token eliminando el prefijo "Bearer ".
            username = jwtUtil.extraerUsuario(token); // Extrae el nombre de usuario del token.
        }

        // Si se obtiene un nombre de usuario y no hay autenticación previa en el contexto de seguridad.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Carga los detalles del usuario desde el servicio de usuarios personalizados.
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            // Valida el token JWT con los detalles del usuario.
            if (jwtUtil.validarToken(token, userDetails)) {
                // Si el token es válido, se crea un objeto de autenticación y se establece en el contexto de seguridad.
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continúa con la cadena de filtros.
        chain.doFilter(request, response);
    }
}
