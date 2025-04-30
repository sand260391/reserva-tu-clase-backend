package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Representa una notificación enviada a un cliente.
 */
@Entity
@Table(name = "notificaciones")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente al que se envía la notificación.
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    /**
     * Mensaje de la notificación.
     */
    @Column(nullable = false)
    private String mensaje;

    /**
     * Fecha y hora de creación de la notificación.
     */
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Indica si la notificación ha sido leída.
     */
    @Column(nullable = false)
    private boolean leida;
}