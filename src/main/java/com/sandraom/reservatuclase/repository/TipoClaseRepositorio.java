package com.sandraom.reservatuclase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandraom.reservatuclase.model.TipoClase;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad TipoClase.
 */
@Repository
public interface TipoClaseRepositorio extends JpaRepository<TipoClase, Long> {
}
