package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad ListaEspera.
 * Proporciona métodos para interactuar con la base de datos de listas de espera.
 */
@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {

    /**
     * Encuentra todas las entradas en la lista de espera para una clase específica,
     * ordenadas por posición ascendente.
     *
     * @param claseId el ID de la clase.
     * @return una lista de entradas en la lista de espera ordenadas por posición.
     */
    List<ListaEspera> findByClaseIdOrderByPosicionAsc(Long claseId);

    /**
     * Encuentra todas las inscripciones en lista de espera de un cliente específico,
     * ordenadas por fecha de inscripción ascendente.
     *
     * @param clienteId el ID del cliente.
     * @return una lista de inscripciones en lista de espera del cliente.
     */
    List<ListaEspera> findByClienteIdOrderByFechaInscripcionAsc(Long clienteId);
}
