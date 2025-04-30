package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Representa una reserva realizada por un cliente para una clase.
 */
@Entity
@Table(name = "reservas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Clase reservada.
     * Relación ManyToOne con la entidad Clase.
     */
    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    private Clase clase;

    /**
     * Cliente que realiza la reserva.
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    /**
     * Fecha y hora en que se realizó la reserva.
     */
    @Column(nullable = false)
    private LocalDateTime fechaReserva;
}
