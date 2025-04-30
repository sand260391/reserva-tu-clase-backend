package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.Notificacion;
import com.sandraom.reservatuclase.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    /**
     * Obtiene todas las notificaciones asociadas a un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de notificaciones del cliente.
     */
    @GetMapping("/cliente/{clienteId}")
    public List<Notificacion> obtenerNotificacionesPorCliente(@PathVariable Long clienteId) {
        return notificacionService.obtenerNotificacionesPorCliente(clienteId);
    }

    /**
     * Crea una nueva notificación.
     *
     * @param notificacion Objeto Notificacion con los datos de la nueva notificación.
     * @return La notificación creada.
     */
    @PostMapping
    public Notificacion crearNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.crearNotificacion(notificacion);
    }

    /**
     * Marca una notificación como leída.
     *
     * @param id ID de la notificación a marcar como leída.
     */
    @PutMapping("/marcar-como-leida/{id}")
    public void marcarComoLeida(@PathVariable Long id) {
        notificacionService.marcarComoLeida(id);
    }
}
