package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad ListaEspera.
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
}
