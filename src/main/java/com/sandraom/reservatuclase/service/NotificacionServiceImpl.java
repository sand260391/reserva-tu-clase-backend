package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Notificacion;
import com.sandraom.reservatuclase.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    /**
     * Obtiene todas las notificaciones asociadas a un cliente específico.
     *
     * @param clienteId ID del cliente cuyas notificaciones se desean obtener.
     * @return Lista de notificaciones asociadas al cliente.
     */
    @Override
    public List<Notificacion> obtenerNotificacionesPorCliente(Long clienteId) {
        // Llama al repositorio para buscar las notificaciones por clienteId.
        return notificacionRepository.findByClienteId(clienteId);
    }

    /**
     * Crea una nueva notificación en el sistema.
     *
     * @param notificacion Objeto Notificacion que se desea crear.
     * @return La notificación creada y guardada en la base de datos.
     */
    @Override
    public Notificacion crearNotificacion(Notificacion notificacion) {
        // Establece la fecha de creación como la fecha actual.
        notificacion.setFechaCreacion(LocalDateTime.now());
        // Marca la notificación como no leída por defecto.
        notificacion.setLeida(false);
        // Guarda la notificación en la base de datos.
        return notificacionRepository.save(notificacion);
    }

    /**
     * Marca una notificación como leída.
     *
     * @param id ID de la notificación que se desea marcar como leída.
     */
    @Override
    public void marcarComoLeida(Long id) {
        // Busca la notificación por su ID.
        Notificacion notificacion = notificacionRepository.findById(id).orElse(null);
        if (notificacion != null) {
            // Si la notificación existe, se marca como leída.
            notificacion.setLeida(true);
            // Se guarda el cambio en la base de datos.
            notificacionRepository.save(notificacion);
        }
    }
}
