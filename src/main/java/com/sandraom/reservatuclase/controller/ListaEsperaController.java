package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.dto.ListaEsperaDTO;
import com.sandraom.reservatuclase.model.ListaEspera;
import com.sandraom.reservatuclase.service.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para gestionar la lista de espera.
 * Proporciona endpoints para agregar, eliminar y consultar inscripciones en la lista de espera.
 */
@RestController
@RequestMapping("/lista-espera")
public class ListaEsperaController {

    @Autowired
    private ListaEsperaService listaEsperaService;

    /**
     * Obtiene la lista de espera asociada a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de espera de la clase.
     */
    @GetMapping("/clase/{claseId}")
    public List<ListaEsperaDTO> obtenerListaEsperaPorClase(@PathVariable Long claseId) {
        return listaEsperaService.obtenerListaEsperaPorClase(claseId).stream().map(listaEspera -> {
            ListaEsperaDTO dto = new ListaEsperaDTO();
            dto.setId(listaEspera.getId());
            dto.setClaseHoraInicio(listaEspera.getClase().getHoraInicio());
            dto.setClaseHoraFin(listaEspera.getClase().getHoraFin());
            dto.setClaseNombre(listaEspera.getClase().getNombre());
            dto.setClaseMonitor(listaEspera.getClase().getMonitor());
            dto.setTipoClaseNombre(listaEspera.getClase().getTipoClase().getNombre());
            dto.setPlazasReservadas(listaEspera.getClase().getReservas().size());
            dto.setPlazasTotales(listaEspera.getClase().getCapacidadMaxima());
            dto.setLongitudListaEspera(listaEspera.getClase().getListaEspera().size());
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * Obtiene las inscripciones en lista de espera de un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de inscripciones en lista de espera del cliente.
     */
    @GetMapping("/cliente/{clienteId}")
    public List<ListaEsperaDTO> obtenerListaEsperaPorCliente(@PathVariable Long clienteId) {
        return listaEsperaService.obtenerListaEsperaPorCliente(clienteId).stream().map(listaEspera -> {
            ListaEsperaDTO dto = new ListaEsperaDTO();
            dto.setId(listaEspera.getId());
            dto.setClaseHoraInicio(listaEspera.getClase().getHoraInicio());
            dto.setClaseHoraFin(listaEspera.getClase().getHoraFin());
            dto.setClaseNombre(listaEspera.getClase().getNombre());
            dto.setClaseMonitor(listaEspera.getClase().getMonitor());
            dto.setTipoClaseNombre(listaEspera.getClase().getTipoClase().getNombre());
            dto.setPlazasReservadas(listaEspera.getClase().getReservas().size());
            dto.setPlazasTotales(listaEspera.getClase().getCapacidadMaxima());
            dto.setLongitudListaEspera(listaEspera.getClase().getListaEspera().size());
            dto.setPosicionEnListaEspera(listaEspera.getClase().getListaEspera().indexOf(listaEspera) + 1); // Calcula la posición
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * Agrega un cliente a la lista de espera de una clase.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return El registro de la lista de espera creado.
     */
    @PostMapping("/agregar")
    public ListaEsperaDTO agregarAListaEspera(@RequestParam Long clienteId, @RequestParam Long claseId) {
        ListaEspera listaEspera = listaEsperaService.agregarAListaEspera(clienteId, claseId);
        ListaEsperaDTO dto = new ListaEsperaDTO();
        dto.setId(listaEspera.getId());
        dto.setClaseHoraInicio(listaEspera.getClase().getHoraInicio());
        dto.setClaseHoraFin(listaEspera.getClase().getHoraFin());
        dto.setClaseNombre(listaEspera.getClase().getNombre());
        dto.setClaseMonitor(listaEspera.getClase().getMonitor());
        dto.setTipoClaseNombre(listaEspera.getClase().getTipoClase().getNombre());
        dto.setPlazasReservadas(listaEspera.getClase().getReservas().size());
        dto.setPlazasTotales(listaEspera.getClase().getCapacidadMaxima());
        dto.setLongitudListaEspera(listaEspera.getClase().getListaEspera().size());
        return dto;
    }

    /**
     * Elimina un cliente de la lista de espera.
     *
     * @param id ID del registro de la lista de espera a eliminar.
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarDeListaEspera(@PathVariable Long id) {
        listaEsperaService.eliminarDeListaEspera(id);
    }

    /**
     * Verifica si un cliente ya está en la lista de espera de una clase específica.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return Un objeto ListaEsperaDTO si el cliente está en la lista de espera, null en caso contrario.
     */
    @GetMapping("/verificar")
    public ListaEsperaDTO verificarListaEspera(@RequestParam Long clienteId, @RequestParam Long claseId) {
        ListaEspera listaEspera = listaEsperaService.obtenerListaEsperaPorClienteYClase(clienteId, claseId);
        if (listaEspera != null) {
            ListaEsperaDTO dto = new ListaEsperaDTO();
            dto.setId(listaEspera.getId());
            dto.setClaseHoraInicio(listaEspera.getClase().getHoraInicio());
            dto.setClaseHoraFin(listaEspera.getClase().getHoraFin());
            dto.setClaseNombre(listaEspera.getClase().getNombre());
            dto.setClaseMonitor(listaEspera.getClase().getMonitor());
            dto.setTipoClaseNombre(listaEspera.getClase().getTipoClase().getNombre());
            dto.setPlazasReservadas(listaEspera.getClase().getReservas().size());
            dto.setPlazasTotales(listaEspera.getClase().getCapacidadMaxima());
            dto.setLongitudListaEspera(listaEspera.getClase().getListaEspera().size());
            dto.setPosicionEnListaEspera(listaEspera.getPosicion());
            return dto;
        }
        return null;
    }
}
