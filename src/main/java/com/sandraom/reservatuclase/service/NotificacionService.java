package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Notificacion;

import java.util.List;

public interface NotificacionService {

    /**
     * Obtiene las notificaciones asociadas a un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de notificaciones del cliente.
     */
    List<Notificacion> obtenerNotificacionesPorCliente(Long clienteId);

    /**
     * Crea una nueva notificación.
     *
     * @param notificacion Objeto de notificación a crear.
     * @return La notificación creada.
     */
    Notificacion crearNotificacion(Notificacion notificacion);

    /**
     * Marca una notificación como leída.
     *
     * @param id ID de la notificación a marcar como leída.
     */
    void marcarComoLeida(Long id);
}
