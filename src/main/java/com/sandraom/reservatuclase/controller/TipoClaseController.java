package com.sandraom.reservatuclase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sandraom.reservatuclase.model.TipoClase;
import com.sandraom.reservatuclase.service.TipoClaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos-clase")
public class TipoClaseController {

    @Autowired
    private TipoClaseService tipoClaseServicio;

    /**
     * Obtiene todos los tipos de clase disponibles.
     *
     * @return Lista de tipos de clase.
     */
    @GetMapping
    public List<TipoClase> obtenerTodosLosTiposDeClase() {
        return tipoClaseServicio.obtenerTodosLosTiposDeClase();
    }

    /**
     * Obtiene un tipo de clase por su ID.
     *
     * @param id ID del tipo de clase.
     * @return El tipo de clase si existe.
     */
    @GetMapping("/{id}")
    public Optional<TipoClase> obtenerTipoDeClasePorId(@PathVariable Long id) {
        return tipoClaseServicio.obtenerTipoDeClasePorId(id);
    }

    /**
     * Crea un nuevo tipo de clase.
     *
     * @param tipoClase Objeto TipoClase con los datos del nuevo tipo.
     * @return El tipo de clase creado.
     */
    @PostMapping
    public TipoClase crearTipoDeClase(@RequestBody TipoClase tipoClase) {
        return tipoClaseServicio.crearTipoDeClase(tipoClase);
    }

    /**
     * Actualiza un tipo de clase existente.
     *
     * @param id ID del tipo de clase a actualizar.
     * @param tipoClase Objeto TipoClase con los datos actualizados.
     * @return El tipo de clase actualizado.
     */
    @PutMapping("/{id}")
    public TipoClase actualizarTipoDeClase(@PathVariable Long id, @RequestBody TipoClase tipoClase) {
        return tipoClaseServicio.actualizarTipoDeClase(id, tipoClase);
    }

    /**
     * Elimina un tipo de clase por su ID.
     *
     * @param id ID del tipo de clase a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarTipoDeClase(@PathVariable Long id) {
        tipoClaseServicio.eliminarTipoDeClase(id);
    }
}
