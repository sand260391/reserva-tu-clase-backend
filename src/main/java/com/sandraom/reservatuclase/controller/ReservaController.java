package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.dto.ReservaDTO;
import com.sandraom.reservatuclase.dto.ReservaExistenteDTO;
import com.sandraom.reservatuclase.model.Reserva;
import com.sandraom.reservatuclase.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las reservas.
 * Proporciona endpoints para crear, cancelar y consultar reservas.
 */
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    /**
     * Obtiene todas las reservas realizadas por un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de reservas asociadas al cliente.
     */
    @GetMapping("/cliente/{clienteId}")
    public List<ReservaDTO> obtenerReservasPorCliente(@PathVariable Long clienteId) {
        return reservaService.obtenerReservasPorCliente(clienteId).stream().map(reserva -> {
            ReservaDTO dto = new ReservaDTO();
            dto.setId(reserva.getId());
            dto.setClaseHoraInicio(reserva.getClase().getHoraInicio());
            dto.setClaseHoraFin(reserva.getClase().getHoraFin());
            dto.setClaseNombre(reserva.getClase().getNombre());
            dto.setClaseMonitor(reserva.getClase().getMonitor());
            dto.setTipoClaseNombre(reserva.getClase().getTipoClase().getNombre());
            dto.setPlazasReservadas(reserva.getClase().getReservas().size());
            dto.setPlazasTotales(reserva.getClase().getCapacidadMaxima());
            dto.setLongitudListaEspera(reserva.getClase().getListaEspera().size());
            return dto;
        }).toList();
    }

    /**
     * Crea una nueva reserva.
     *
     * @param reserva Objeto Reserva con los datos de la nueva reserva.
     * @return La reserva creada.
     */
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    /**
     * Cancela una reserva existente.
     *
     * @param id ID de la reserva a cancelar.
     */
    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
    }

    /**
     * Obtiene todas las reservas asociadas a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de reservas asociadas a la clase.
     */
    @GetMapping("/clase/{claseId}")
    public List<Reserva> obtenerReservasPorClase(@PathVariable Long claseId) {
        return reservaService.obtenerReservasPorClase(claseId);
    }

    /**
     * Verifica si un cliente tiene una reserva para una clase específica.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return Un objeto ReservaExistenteDTO si existe, null en caso contrario.
     */
    @GetMapping("/verificar")
    public ReservaExistenteDTO verificarReserva(@RequestParam Long clienteId, @RequestParam Long claseId) {
        Reserva reserva = reservaService.obtenerReservaPorClienteYClase(clienteId, claseId);
        if (reserva != null) {
            ReservaExistenteDTO dto = new ReservaExistenteDTO();
            dto.setId(reserva.getId());
            dto.setUsuarioId(reserva.getCliente().getId());
            dto.setClaseId(reserva.getClase().getId());
            return dto;
        }
        return null;
    }
}
