package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Evaluacion;
import com.sandraom.reservatuclase.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementación del servicio para gestionar evaluaciones.
 */
@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    /**
     * Obtiene las evaluaciones asociadas a un tipo de clase específico.
     * 
     * @param tipoClaseId el ID del tipo de clase.
     * @return una lista de evaluaciones asociadas al tipo de clase.
     */
    @Override
    public List<Evaluacion> obtenerEvaluacionesPorTipoClase(Long tipoClaseId) {
        return evaluacionRepository.findByTipoClaseId(tipoClaseId);
    }

    /**
     * Obtiene las evaluaciones realizadas por un monitor específico.
     * 
     * @param monitorId el ID del monitor.
     * @return una lista de evaluaciones realizadas por el monitor.
     */
    @Override
    public List<Evaluacion> obtenerEvaluacionesPorMonitor(Long monitorId) {
        return evaluacionRepository.findByMonitorId(monitorId);
    }

    /**
     * Crea una nueva evaluación.
     * 
     * @param evaluacion la evaluación a crear.
     * @return la evaluación creada.
     */
    @Override
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        evaluacion.setFechaEvaluacion(LocalDateTime.now()); // Establece la fecha actual.
        return evaluacionRepository.save(evaluacion);
    }

    /**
     * Elimina una evaluación por su ID.
     * 
     * @param id el ID de la evaluación a eliminar.
     */
    @Override
    public void eliminarEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }
}
