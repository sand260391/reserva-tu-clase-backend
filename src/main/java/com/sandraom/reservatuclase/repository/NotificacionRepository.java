package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Notificacion.
 * Proporciona métodos para interactuar con la base de datos de notificaciones.
 */
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    /**
     * Encuentra todas las notificaciones asociadas a un cliente específico.
     *
     * @param clienteId el ID del cliente.
     * @return una lista de notificaciones asociadas al cliente.
     */
    List<Notificacion> findByClienteId(Long clienteId);
}
