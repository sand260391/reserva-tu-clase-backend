package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.Reserva;
import com.sandraom.reservatuclase.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Reserva> obtenerReservasPorCliente(@PathVariable Long clienteId) {
        return reservaService.obtenerReservasPorCliente(clienteId);
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
}
