package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Reserva;

import java.util.List;

public interface ReservaService {

    /**
     * Obtiene las reservas realizadas por un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de reservas del cliente.
     */
    List<Reserva> obtenerReservasPorCliente(Long clienteId);

    /**
     * Crea una nueva reserva.
     *
     * @param reserva Objeto de reserva a crear.
     * @return La reserva creada.
     */
    Reserva crearReserva(Reserva reserva);

    /**
     * Cancela una reserva existente.
     *
     * @param id ID de la reserva a cancelar.
     */
    void cancelarReserva(Long id);

    /**
     * Obtiene las reservas asociadas a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de reservas de la clase.
     */
    List<Reserva> obtenerReservasPorClase(Long claseId);
}
