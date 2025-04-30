package com.sandraom.reservatuclase.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Representa un tipo de clase (e.g., yoga, pilates).
 */
@Entity
@Table(name = "tipos_clases")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del tipo de clase.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Clases asociadas a este tipo.
     * Relación OneToMany con la entidad Clase.
     */
    @OneToMany(mappedBy = "tipoClase")
    private List<Clase> clases;

    /**
     * Evaluaciones asociadas a este tipo de clase.
     * Relación OneToMany con la entidad Evaluacion.
     */
    @OneToMany(mappedBy = "tipoClase")
    private List<Evaluacion> evaluaciones;
}