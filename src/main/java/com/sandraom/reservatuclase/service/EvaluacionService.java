package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Evaluacion;

import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con las evaluaciones.
 */
public interface EvaluacionService {

    /**
     * Obtiene las evaluaciones asociadas a un tipo de clase específico.
     * 
     * @param tipoClaseId el ID del tipo de clase.
     * @return una lista de evaluaciones asociadas al tipo de clase.
     */
    List<Evaluacion> obtenerEvaluacionesPorTipoClase(Long tipoClaseId);

    /**
     * Obtiene las evaluaciones realizadas por un monitor específico.
     * 
     * @param monitorId el ID del monitor.
     * @return una lista de evaluaciones realizadas por el monitor.
     */
    List<Evaluacion> obtenerEvaluacionesPorMonitor(Long monitorId);

    /**
     * Obtiene todas las evaluaciones realizadas.
     *
     * @return una lista de todas las evaluaciones.
     */
    List<Evaluacion> obtenerTodasLasEvaluaciones();

    /**
     * Crea una nueva evaluación.
     * 
     * @param evaluacion la evaluación a crear.
     * @return la evaluación creada.
     */
    Evaluacion crearEvaluacion(Evaluacion evaluacion);

    /**
     * Elimina una evaluación por su ID.
     * 
     * @param id el ID de la evaluación a eliminar.
     */
    void eliminarEvaluacion(Long id);
}
