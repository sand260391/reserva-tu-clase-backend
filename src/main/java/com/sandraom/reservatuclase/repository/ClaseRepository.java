package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Clase.
 */
@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
}
