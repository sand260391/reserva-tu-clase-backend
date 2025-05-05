package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.Usuario;
import com.sandraom.reservatuclase.service.CustomUserDetailsService;
import com.sandraom.reservatuclase.service.UsuarioService;
import com.sandraom.reservatuclase.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la autenticación y registro de usuarios.
 * Proporciona endpoints para iniciar sesión y registrar nuevos usuarios.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para iniciar sesión.
     * Autentica al usuario y genera un token JWT si las credenciales son válidas.
     *
     * @param usuario Objeto Usuario con las credenciales (email y contraseña).
     * @return Token JWT si la autenticación es exitosa.
     * @throws Exception Si las credenciales son inválidas.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword())
        );

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(usuario.getEmail());
        final String jwt = jwtUtil.crearToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     *
     * @param usuario Objeto Usuario con los datos del nuevo usuario.
     * @return El usuario registrado.
     */
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
