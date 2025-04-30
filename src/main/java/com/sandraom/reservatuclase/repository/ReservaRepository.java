package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Reserva.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Encuentra todas las reservas realizadas por un cliente específico.
     *
     * @param clienteId el ID del cliente.
     * @return una lista de reservas asociadas al cliente.
     */
    List<Reserva> findByClienteId(Long clienteId);

    /**
     * Encuentra todas las reservas asociadas a una clase específica.
     *
     * @param claseId el ID de la clase.
     * @return una lista de reservas asociadas a la clase.
     */
    List<Reserva> findByClaseId(Long claseId);
}
