package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Evaluacion.
 * Proporciona métodos para interactuar con la base de datos de evaluaciones.
 */
@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    /**
     * Encuentra todas las evaluaciones asociadas a un tipo de clase específico.
     *
     * @param tipoClaseId el ID del tipo de clase.
     * @return una lista de evaluaciones asociadas al tipo de clase.
     */
    List<Evaluacion> findByTipoClaseId(Long tipoClaseId);

    /**
     * Encuentra todas las evaluaciones realizadas por un monitor específico.
     *
     * @param monitorId el ID del monitor.
     * @return una lista de evaluaciones asociadas al monitor.
     */
    List<Evaluacion> findByMonitorId(Long monitorId);
}
