package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos para la gestión de usuarios en el sistema.
 * Proporciona operaciones CRUD básicas.
 */
public interface UsuarioService {

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario El objeto Usuario a registrar.
     * @return El usuario registrado.
     */
    Usuario registrarUsuario(Usuario usuario);

    /**
     * Lista todos los usuarios registrados en el sistema.
     *
     * @return Una lista de usuarios.
     */
    List<Usuario> listarUsuarios();

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<Usuario> obtenerUsuarioPorId(Long id);

    /**
     * Obtiene un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<Usuario> obtenerUsuarioPorEmail(String email);

    /**
     * Obtiene una lista de usuarios por su rol.
     *
     * @param rol El rol de los usuarios a buscar.
     * @return Lista de usuarios con el rol especificado.
     */
    List<Usuario> obtenerUsuariosPorRol(Usuario.Rol rol);

    /**
     * Elimina un usuario del sistema por su ID.
     *
     * @param id El ID del usuario a eliminar.
     */
    void eliminarUsuario(Long id);

    /**
     * Actualiza la información de un usuario existente.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     * @return El usuario actualizado.
     */
    Usuario actualizarUsuario(Usuario usuario);

    /**
     * Encripta una contraseña utilizando el codificador configurado.
     *
     * @param password La contraseña en texto plano.
     * @return La contraseña encriptada.
     */
    String encriptarPassword(String password);
}

