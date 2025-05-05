package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Usuario;
import com.sandraom.reservatuclase.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz UsuarioService.
 * Proporciona la lógica de negocio para la gestión de usuarios en el sistema.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario Objeto de tipo Usuario con los datos del usuario a registrar.
     * @return El usuario registrado.
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        // Encriptamos la contraseña antes de guardarla
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    /**
     * Lista todos los usuarios registrados.
     *
     * @return Lista de usuarios.
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return Un Optional que contiene el usuario si existe.
     */
    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Obtiene un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return Un Optional que contiene el usuario si se encuentra.
     */
    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Obtiene una lista de usuarios por su rol.
     *
     * @param rol El rol de los usuarios a buscar.
     * @return Lista de usuarios con el rol especificado.
     */
    @Override
    public List<Usuario> obtenerUsuariosPorRol(Usuario.Rol rol) {
        return usuarioRepository.findByRol(rol);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     */
    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param usuario Objeto de tipo Usuario con los datos actualizados.
     * @return El usuario actualizado.
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }
}

