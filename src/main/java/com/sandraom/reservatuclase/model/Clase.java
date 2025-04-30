package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa una clase que puede ser reservada por los usuarios.
 */
@Entity
@Table(name = "clases")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la clase.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Tipo de clase (e.g., yoga, pilates).
     * Relación ManyToOne con la entidad TipoClase.
     */
    @ManyToOne
    @JoinColumn(name = "tipo_clase_id", nullable = false)
    private TipoClase tipoClase;

    /**
     * Monitor asignado a la clase.
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "monitor_id", nullable = false)
    private Usuario monitor;

    /**
     * Sala donde se imparte la clase.
     */
    @Column(nullable = false)
    private String sala;

    /**
     * Hora de inicio de la clase.
     */
    @Column(nullable = false)
    private LocalDateTime horaInicio;

    /**
     * Hora de finalización de la clase.
     */
    @Column(nullable = false)
    private LocalDateTime horaFin;

    /**
     * Capacidad máxima de asistentes para la clase.
     */
    @Column(nullable = false)
    private int capacidadMaxima;

    /**
     * Reservas asociadas a la clase.
     * Relación OneToMany con la entidad Reserva.
     */
    @OneToMany(mappedBy = "clase")
    private List<Reserva> reservas;

    /**
     * Lista de espera asociada a la clase.
     * Relación OneToMany con la entidad ListaEspera.
     */
    @OneToMany(mappedBy = "clase")
    private List<ListaEspera> listaEspera;
}
