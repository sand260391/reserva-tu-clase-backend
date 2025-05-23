package com.sandraom.reservatuclase.repository;

import com.sandraom.reservatuclase.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email el correo electrónico del usuario.
     * @return un Optional que contiene el usuario si se encuentra.
     */
    Optional<Usuario> findByEmail(String email);  // Buscar por email

    /**
     * Busca usuarios por su rol.
     *
     * @param rol El rol de los usuarios.
     * @return Lista de usuarios con el rol especificado.
     */
    List<Usuario> findByRol(Usuario.Rol rol);
}
