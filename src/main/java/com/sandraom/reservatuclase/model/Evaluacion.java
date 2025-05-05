package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Representa una evaluación realizada por un cliente sobre un tipo de clase.
 * Contiene información sobre el cliente, el tipo de clase, el monitor, la calificación, el comentario y la fecha.
 */
@Entity
@Table(name = "evaluaciones")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente que realiza la evaluación.
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    /**
     * Tipo de clase evaluado.
     * Relación ManyToOne con la entidad TipoClase.
     */
    @ManyToOne
    @JoinColumn(name = "tipo_clase_id", nullable = false)
    private TipoClase tipoClase;

    /**
     * Monitor evaluado (opcional).
     * Relación ManyToOne con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private Usuario monitor;

    /**
     * Calificación otorgada (e.g., 1 a 5).
     */
    @Column(nullable = false)
    private int calificacion;

    /**
     * Comentario adicional del cliente.
     */
    @Column(nullable = false)
    private String comentario;

    /**
     * Fecha y hora en que se realizó la evaluación.
     */
    @Column(nullable = false)
    private LocalDateTime fechaEvaluacion;
}