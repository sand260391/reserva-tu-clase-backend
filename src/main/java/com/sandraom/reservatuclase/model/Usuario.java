package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un usuario del sistema.
 * Puede tener diferentes roles como ADMIN, MONITOR o CLIENTE.
 */
@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Correo electrónico único del usuario.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Nombre del usuario.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Apellidos del usuario.
     */
    @Column(nullable = false)
    private String apellidos;

    /**
     * Contraseña del usuario.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Rol del usuario en el sistema (ADMIN, MONITOR o CLIENTE).
     */
    @Enumerated(EnumType.STRING)
    private Rol rol;

    /**
     * Enum que define los roles posibles para un usuario.
     */
    public enum Rol {
        ADMIN, MONITOR, CLIENTE
    }
}
