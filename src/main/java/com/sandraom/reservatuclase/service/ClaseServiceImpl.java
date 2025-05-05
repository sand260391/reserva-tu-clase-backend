package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.Clase;
import com.sandraom.reservatuclase.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para gestionar las operaciones relacionadas con las clases.
 */
@Service
public class ClaseServiceImpl implements ClaseService {

    /**
     * Repositorio para acceder a los datos de las clases.
     */
    @Autowired
    private ClaseRepository claseRepository;

    /**
     * Obtiene todas las clases disponibles.
     * 
     * @return una lista de todas las clases.
     */
    @Override
    public List<Clase> obtenerTodasLasClases() {
        return claseRepository.findAll();
    }

    /**
     * Obtiene una clase específica por su ID.
     * 
     * @param id el ID de la clase.
     * @return la clase correspondiente al ID, o null si no existe.
     */
    @Override
    public Clase obtenerClasePorId(Long id) {
        return claseRepository.findById(id).orElse(null);
    }

    /**
     * Crea una nueva clase.
     * 
     * @param clase la clase a crear.
     * @return la clase creada.
     */
    @Override
    public Clase crearClase(Clase clase) {
        return claseRepository.save(clase);
    }

    /**
     * Actualiza una clase existente.
     * 
     * @param id el ID de la clase a actualizar.
     * @param clase los nuevos datos de la clase.
     * @return la clase actualizada, o null si no existe.
     */
    @Override
    public Clase actualizarClase(Long id, Clase clase) {
        if (claseRepository.existsById(id)) {
            clase.setId(id); // Establece el ID antes de guardar.
            return claseRepository.save(clase);
        }
        return null;
    }

    /**
     * Elimina una clase por su ID.
     * 
     * @param id el ID de la clase a eliminar.
     */
    @Override
    public void eliminarClase(Long id) {
        claseRepository.deleteById(id);
    }
}
