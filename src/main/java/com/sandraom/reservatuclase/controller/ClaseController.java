package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.dto.ClaseDTO;
import com.sandraom.reservatuclase.model.Clase;
import com.sandraom.reservatuclase.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

/**
 * Controlador para gestionar las clases.
 * Proporciona endpoints para CRUD de clases y consulta de clases disponibles.
 */
@RestController
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    /**
     * Obtiene todas las clases disponibles.
     *
     * @return Lista de clases.
     */
    @GetMapping
    public List<ClaseDTO> obtenerTodasLasClases() {
        return claseService.obtenerTodasLasClases().stream().map(clase -> {
            ClaseDTO dto = new ClaseDTO();
            dto.setId(clase.getId());
            dto.setNombre(clase.getNombre());
            dto.setTipoClase(clase.getTipoClase());
            dto.setMonitor(clase.getMonitor());
            dto.setSala(clase.getSala());
            dto.setHoraInicio(clase.getHoraInicio());
            dto.setHoraFin(clase.getHoraFin());
            dto.setCapacidadMaxima(clase.getCapacidadMaxima());
            dto.setPlazasReservadas(clase.getReservas().size());
            dto.setLongitudListaEspera(clase.getListaEspera().size());
            return dto;
        }).toList();
    }

    /**
     * Obtiene una clase por su ID.
     *
     * @param id ID de la clase.
     * @return La clase si existe.
     */
    @GetMapping("/{id}")
    public ClaseDTO obtenerClasePorId(@PathVariable Long id) {
        Clase clase = claseService.obtenerClasePorId(id);
        ClaseDTO dto = new ClaseDTO();
        dto.setId(clase.getId());
        dto.setNombre(clase.getNombre());
        dto.setTipoClase(clase.getTipoClase());
        dto.setMonitor(clase.getMonitor());
        dto.setSala(clase.getSala());
        dto.setHoraInicio(clase.getHoraInicio());
        dto.setHoraFin(clase.getHoraFin());
        dto.setCapacidadMaxima(clase.getCapacidadMaxima());
        dto.setPlazasReservadas(clase.getReservas().size());
        dto.setLongitudListaEspera(clase.getListaEspera().size());
        return dto;
    }

    /**
     * Crea una nueva clase.
     *
     * @param clase Objeto Clase con los datos de la nueva clase.
     * @return La clase creada.
     */
    @PostMapping
    public ClaseDTO crearClase(@RequestBody Clase clase) {
        Clase claseCreada = claseService.crearClase(clase);
        ClaseDTO dto = new ClaseDTO();
        dto.setId(claseCreada.getId());
        dto.setNombre(claseCreada.getNombre());
        dto.setTipoClase(claseCreada.getTipoClase());
        dto.setMonitor(claseCreada.getMonitor());
        dto.setSala(claseCreada.getSala());
        dto.setHoraInicio(claseCreada.getHoraInicio());
        dto.setHoraFin(claseCreada.getHoraFin());
        dto.setCapacidadMaxima(claseCreada.getCapacidadMaxima());
        dto.setPlazasReservadas(claseCreada.getReservas().size());
        dto.setLongitudListaEspera(claseCreada.getListaEspera().size());
        return dto;
    }

    /**
     * Actualiza una clase existente.
     *
     * @param id    ID de la clase a actualizar.
     * @param clase Objeto Clase con los datos actualizados.
     * @return La clase actualizada.
     */
    @PutMapping("/{id}")
    public ClaseDTO actualizarClase(@PathVariable Long id, @RequestBody Clase clase) {
        Clase claseCreada = claseService.actualizarClase(id, clase);
        ClaseDTO dto = new ClaseDTO();
        dto.setId(claseCreada.getId());
        dto.setNombre(claseCreada.getNombre());
        dto.setTipoClase(claseCreada.getTipoClase());
        dto.setMonitor(claseCreada.getMonitor());
        dto.setSala(claseCreada.getSala());
        dto.setHoraInicio(claseCreada.getHoraInicio());
        dto.setHoraFin(claseCreada.getHoraFin());
        dto.setCapacidadMaxima(claseCreada.getCapacidadMaxima());
        dto.setPlazasReservadas(claseCreada.getReservas().size());
        dto.setLongitudListaEspera(claseCreada.getListaEspera().size());
        return dto;
        
    }

    /**
     * Elimina una clase por su ID.
     *
     * @param id ID de la clase a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarClase(@PathVariable Long id) {
        claseService.eliminarClase(id);
    }

    /**
     * Obtiene las clases disponibles (que no hayan comenzado aún).
     *
     * @return Lista de clases disponibles.
     */
    @GetMapping("/disponibles")
    public List<ClaseDTO> obtenerClasesDisponibles() {
        return claseService.obtenerTodasLasClases().stream()
                .filter(clase -> clase.getHoraInicio().isAfter(LocalDateTime.now()))
                .map(clase -> {
                    ClaseDTO dto = new ClaseDTO();
                    dto.setId(clase.getId());
                    dto.setNombre(clase.getNombre());
                    dto.setTipoClase(clase.getTipoClase());
                    dto.setMonitor(clase.getMonitor());
                    dto.setSala(clase.getSala());
                    dto.setHoraInicio(clase.getHoraInicio());
                    dto.setHoraFin(clase.getHoraFin());
                    dto.setCapacidadMaxima(clase.getCapacidadMaxima());
                    dto.setPlazasReservadas(clase.getReservas().size());
                    dto.setLongitudListaEspera(clase.getListaEspera().size());
                    return dto;
                }).toList();
    }
}
