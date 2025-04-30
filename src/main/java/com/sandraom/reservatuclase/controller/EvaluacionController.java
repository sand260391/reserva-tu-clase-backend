package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.Evaluacion;
import com.sandraom.reservatuclase.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    /**
     * Obtiene todas las evaluaciones asociadas a un tipo de clase específico.
     *
     * @param tipoClaseId ID del tipo de clase.
     * @return Lista de evaluaciones del tipo de clase.
     */
    @GetMapping("/tipo-clase/{tipoClaseId}")
    public List<Evaluacion> obtenerEvaluacionesPorTipoClase(@PathVariable Long tipoClaseId) {
        return evaluacionService.obtenerEvaluacionesPorTipoClase(tipoClaseId);
    }

    /**
     * Obtiene todas las evaluaciones asociadas a un monitor específico.
     *
     * @param monitorId ID del monitor.
     * @return Lista de evaluaciones del monitor.
     */
    @GetMapping("/monitor/{monitorId}")
    public List<Evaluacion> obtenerEvaluacionesPorMonitor(@PathVariable Long monitorId) {
        return evaluacionService.obtenerEvaluacionesPorMonitor(monitorId);
    }

    /**
     * Crea una nueva evaluación.
     *
     * @param evaluacion Objeto Evaluacion con los datos de la nueva evaluación.
     * @return La evaluación creada.
     */
    @PostMapping
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crearEvaluacion(evaluacion);
    }

    /**
     * Elimina una evaluación existente.
     *
     * @param id ID de la evaluación a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarEvaluacion(@PathVariable Long id) {
        evaluacionService.eliminarEvaluacion(id);
    }
}
