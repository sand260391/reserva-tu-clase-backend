package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Representa una inscripción en la lista de espera para una clase.
 */
@Entity
@Table(name = "listas_espera")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaEspera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente inscrito en la lista de espera.
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    /**
     * Clase para la cual se realiza la inscripción en la lista de espera.
     * Relación ManyToOne con la entidad Clase.
     */
    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    private Clase clase;

    /**
     * Fecha y hora de inscripción en la lista de espera.
     */
    @Column(nullable = false)
    private LocalDateTime fechaInscripcion;

    /**
     * Posición del cliente en la lista de espera.
     */
    @Column(nullable = false)
    private int posicion;
}