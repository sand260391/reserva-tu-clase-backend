package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.ListaEspera;

import java.util.List;

public interface ListaEsperaService {

    /**
     * Obtiene la lista de espera asociada a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de espera ordenada por posición.
     */
    List<ListaEspera> obtenerListaEsperaPorClase(Long claseId);

    /**
     * Obtiene las inscripciones en lista de espera de un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de inscripciones en lista de espera del cliente.
     */
    List<ListaEspera> obtenerListaEsperaPorCliente(Long clienteId);

    /**
     * Agrega un cliente a la lista de espera de una clase.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return La entidad de lista de espera creada.
     */
    ListaEspera agregarAListaEspera(Long clienteId, Long claseId);

    /**
     * Elimina un registro de la lista de espera.
     *
     * @param id ID del registro de lista de espera a eliminar.
     */
    void eliminarDeListaEspera(Long id);
}