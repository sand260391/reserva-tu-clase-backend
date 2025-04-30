package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.TipoClase;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos para gestionar los tipos de clase.
 * Proporciona operaciones CRUD para la entidad TipoClase.
 */
public interface TipoClaseService {

    /**
     * Obtiene todos los tipos de clase disponibles.
     *
     * @return una lista de todos los tipos de clase.
     */
    List<TipoClase> obtenerTodosLosTiposDeClase();

    /**
     * Obtiene un tipo de clase por su identificador único.
     *
     * @param id el identificador único del tipo de clase.
     * @return un Optional que contiene el tipo de clase si se encuentra, o vacío si no.
     */
    Optional<TipoClase> obtenerTipoDeClasePorId(Long id);

    /**
     * Crea un nuevo tipo de clase.
     *
     * @param tipoClase el objeto TipoClase a crear.
     * @return el objeto TipoClase creado.
     */
    TipoClase crearTipoDeClase(TipoClase tipoClase);

    /**
     * Actualiza un tipo de clase existente.
     *
     * @param id el identificador único del tipo de clase a actualizar.
     * @param tipoClase el objeto TipoClase con los nuevos datos.
     * @return el objeto TipoClase actualizado.
     */
    TipoClase actualizarTipoDeClase(Long id, TipoClase tipoClase);

    /**
     * Elimina un tipo de clase por su identificador único.
     *
     * @param id el identificador único del tipo de clase a eliminar.
     */
    void eliminarTipoDeClase(Long id);
}