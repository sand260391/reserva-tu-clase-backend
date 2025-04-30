package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Clase;

import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con las clases.
 */
public interface ClaseService {

    /**
     * Obtiene todas las clases disponibles.
     * 
     * @return una lista de todas las clases.
     */
    List<Clase> obtenerTodasLasClases();

    /**
     * Obtiene una clase específica por su ID.
     * 
     * @param id el ID de la clase.
     * @return la clase correspondiente al ID, o null si no existe.
     */
    Clase obtenerClasePorId(Long id);

    /**
     * Crea una nueva clase.
     * 
     * @param clase la clase a crear.
     * @return la clase creada.
     */
    Clase crearClase(Clase clase);

    /**
     * Actualiza una clase existente.
     * 
     * @param id el ID de la clase a actualizar.
     * @param clase los nuevos datos de la clase.
     * @return la clase actualizada, o null si no existe.
     */
    Clase actualizarClase(Long id, Clase clase);

    /**
     * Elimina una clase por su ID.
     * 
     * @param id el ID de la clase a eliminar.
     */
    void eliminarClase(Long id);
}
