package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.dto.ClaseDTO;
import com.sandraom.reservatuclase.model.Clase;
import com.sandraom.reservatuclase.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Clase crearClase(@RequestBody Clase clase) {
        return claseService.crearClase(clase);
    }

    /**
     * Actualiza una clase existente.
     *
     * @param id    ID de la clase a actualizar.
     * @param clase Objeto Clase con los datos actualizados.
     * @return La clase actualizada.
     */
    @PutMapping("/{id}")
    public Clase actualizarClase(@PathVariable Long id, @RequestBody Clase clase) {
        return claseService.actualizarClase(id, clase);
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
}
