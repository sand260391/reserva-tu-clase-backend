package com.sandraom.reservatuclase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandraom.reservatuclase.model.TipoClase;
import com.sandraom.reservatuclase.repository.TipoClaseRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TipoClaseServiceImpl implements TipoClaseService {

    @Autowired
    private TipoClaseRepositorio tipoClaseRepositorio;

    /**
     * Obtiene todos los tipos de clase disponibles.
     *
     * @return Lista de tipos de clase.
     */
    public List<TipoClase> obtenerTodosLosTiposDeClase() {
        return tipoClaseRepositorio.findAll();
    }

    /**
     * Obtiene un tipo de clase por su ID.
     *
     * @param id ID del tipo de clase.
     * @return Un Optional que contiene el tipo de clase si existe.
     */
    public Optional<TipoClase> obtenerTipoDeClasePorId(Long id) {
        return tipoClaseRepositorio.findById(id);
    }

    /**
     * Crea un nuevo tipo de clase.
     *
     * @param tipoClase Objeto de tipo TipoClase con los datos del nuevo tipo.
     * @return El tipo de clase creado.
     */
    public TipoClase crearTipoDeClase(TipoClase tipoClase) {
        return tipoClaseRepositorio.save(tipoClase);
    }

    /**
     * Actualiza un tipo de clase existente.
     *
     * @param id ID del tipo de clase a actualizar.
     * @param tipoClase Objeto de tipo TipoClase con los datos actualizados.
     * @return El tipo de clase actualizado o null si no existe.
     */
    public TipoClase actualizarTipoDeClase(Long id, TipoClase tipoClase) {
        if (tipoClaseRepositorio.existsById(id)) {
            tipoClase.setId(id);
            return tipoClaseRepositorio.save(tipoClase);
        }
        return null;
    }

    /**
     * Elimina un tipo de clase por su ID.
     *
     * @param id ID del tipo de clase a eliminar.
     */
    public void eliminarTipoDeClase(Long id) {
        tipoClaseRepositorio.deleteById(id);
    }
}
