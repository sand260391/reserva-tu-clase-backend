package com.sandraom.reservatuclase.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;

/**
 * Clase utilitaria para la generación, validación y extracción de información de tokens JWT.
 * Proporciona métodos para crear tokens, extraer información de ellos y validarlos.
 */
@Component
public class JwtUtil {

    private String SECRET_KEY = "mySuperSecretKeyForJWTAuthenticationSandraOsunaMontes";

    /**
     * Extrae el nombre de usuario (subject) del token JWT.
     *
     * @param token el token JWT del cual extraer el usuario.
     * @return el nombre de usuario contenido en el token.
     */
    public String extraerUsuario(String token) {
        return extraerReclamo(token, Claims::getSubject);
    }

    /**
     * Extrae la fecha de expiración del token JWT.
     *
     * @param token el token JWT del cual extraer la fecha de expiración.
     * @return la fecha de expiración del token.
     */
    public Date extraerExpiracion(String token) {
        return extraerReclamo(token, Claims::getExpiration);
    }

    /**
     * Extrae un reclamo específico del token JWT utilizando una función de resolución.
     *
     * @param token el token JWT del cual extraer el reclamo.
     * @param claimsResolver la función que define cómo resolver el reclamo.
     * @param <T> el tipo del reclamo a extraer.
     * @return el valor del reclamo extraído.
     */
    public <T> T extraerReclamo(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrae todos los reclamos del token JWT.
     *
     * @param token el token JWT del cual extraer los reclamos.
     * @return los reclamos contenidos en el token.
     */
    private Claims extractAllClaims(String token) {
        // Se utiliza el parser de JWT para verificar y extraer los reclamos del token.
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    /**
     * Verifica si el token JWT ha expirado.
     *
     * @param token el token JWT a verificar.
     * @return true si el token ha expirado, false en caso contrario.
     */
    private Boolean esTokenExpirado(String token) {
        return extraerExpiracion(token).before(new Date());
    }

    /**
     * Obtiene la clave de firma utilizada para firmar y verificar los tokens JWT.
     *
     * @return la clave secreta en formato SecretKey.
     */
    private SecretKey getSigningKey() {
        // Decodifica la clave secreta desde Base64 y la convierte en una clave HMAC.
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Crea un token JWT para un usuario específico.
     *
     * @param userDetails los detalles del usuario para los cuales se crea el token.
     * @return el token JWT generado.
     */
    public String crearToken(UserDetails userDetails) {
        // Se establece el subject, los reclamos, la fecha de emisión y la expiración del token.
        return Jwts.builder()
            .subject(userDetails.getUsername())
            .claim("role", userDetails.getAuthorities().toString())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 3)) // 3 horas
            .signWith(getSigningKey(), Jwts.SIG.HS256)
            .compact();
    }

    /**
     * Valida un token JWT verificando el nombre de usuario y la expiración.
     *
     * @param token el token JWT a validar.
     * @param userDetails los detalles del usuario contra los cuales validar el token.
     * @return true si el token es válido, false en caso contrario.
     */
    public Boolean validarToken(String token, UserDetails userDetails) {
        final String username = extraerUsuario(token);
        return (username.equals(userDetails.getUsername()) && !esTokenExpirado(token));
    }
}
