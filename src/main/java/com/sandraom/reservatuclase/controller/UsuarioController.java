package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.Usuario;
import com.sandraom.reservatuclase.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para registrar un nuevo usuario.
     *
     * @param usuario Objeto Usuario con los datos del nuevo usuario.
     * @return El usuario registrado.
     */
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    /**
     * Endpoint para listar todos los usuarios.
     *
     * @return Lista de usuarios.
     */
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    /**
     * Endpoint para obtener un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return El usuario si existe, o un código 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para obtener la información del usuario actual a partir de su JWT.
     *
     * @param userDetails Detalles del usuario autenticado.
     * @return Información del usuario actual.
     */
    @GetMapping("/me")
    public ResponseEntity<Usuario> obtenerUsuarioActual(@AuthenticationPrincipal UserDetails userDetails) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorEmail(userDetails.getUsername());
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para eliminar un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return Mensaje de éxito.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado con éxito.");
    }

    /**
     * Endpoint para actualizar un usuario existente.
     *
     * @param id ID del usuario a actualizar.
     * @param usuarioActualizado Objeto Usuario con los datos actualizados.
     * @return El usuario actualizado o un código 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            Usuario usuarioActualizadoFinal = usuarioService.actualizarUsuario(usuarioExistente);
            return ResponseEntity.ok(usuarioActualizadoFinal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
