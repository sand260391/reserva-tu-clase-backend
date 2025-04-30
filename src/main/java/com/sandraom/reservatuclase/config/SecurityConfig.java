package com.sandraom.reservatuclase.config;

import com.sandraom.reservatuclase.security.JwtFiltroAutenticacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de seguridad para la aplicación.
 * Define las políticas de seguridad, filtros y configuración de CORS.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad.
     *
     * @param http el objeto HttpSecurity para configurar las políticas de seguridad.
     * @return la cadena de filtros de seguridad configurada.
     * @throws Exception si ocurre un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/usuarios/registro").permitAll()
                .requestMatchers("/usuarios/**").hasRole("ADMIN")
                .requestMatchers("/tipos-clase/**").hasRole("ADMIN")
                .requestMatchers("/clases/**").hasAnyRole("ADMIN", "MONITOR")
                .requestMatchers("/reservas/**").hasRole("CLIENTE")
                .requestMatchers("/lista-espera/**").hasRole("CLIENTE")
                .requestMatchers("/notificaciones/**").hasRole("CLIENTE")
                .requestMatchers("/evaluaciones/**").hasRole("CLIENTE")
                .anyRequest().authenticated())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFiltroAutenticacion(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Proporciona un codificador de contraseñas basado en BCrypt.
     *
     * @return una instancia de PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Proporciona el administrador de autenticación.
     *
     * @param authenticationConfiguration la configuración de autenticación.
     * @return una instancia de AuthenticationManager.
     * @throws Exception si ocurre un error al obtener el administrador de autenticación.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Proporciona el filtro de autenticación JWT.
     *
     * @return una instancia de JwtFiltroAutenticacion.
     */
    @Bean
    public JwtFiltroAutenticacion jwtFiltroAutenticacion() {
        return new JwtFiltroAutenticacion();
    }

    /**
     * Configura las políticas de CORS para la aplicación.
     *
     * @return una instancia de WebMvcConfigurer con la configuración de CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost") // o "http://localhost:5500" si usas Live Server
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }
}
