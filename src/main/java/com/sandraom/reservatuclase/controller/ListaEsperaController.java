package com.sandraom.reservatuclase.controller;

import com.sandraom.reservatuclase.model.ListaEspera;
import com.sandraom.reservatuclase.service.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-espera")
public class ListaEsperaController {

    @Autowired
    private ListaEsperaService listaEsperaService;

    /**
     * Obtiene la lista de espera asociada a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de espera de la clase.
     */
    @GetMapping("/clase/{claseId}")
    public List<ListaEspera> obtenerListaEsperaPorClase(@PathVariable Long claseId) {
        return listaEsperaService.obtenerListaEsperaPorClase(claseId);
    }

    /**
     * Agrega un cliente a la lista de espera de una clase.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return El registro de la lista de espera creado.
     */
    @PostMapping("/agregar")
    public ListaEspera agregarAListaEspera(@RequestParam Long clienteId, @RequestParam Long claseId) {
        return listaEsperaService.agregarAListaEspera(clienteId, claseId);
    }

    /**
     * Elimina un cliente de la lista de espera.
     *
     * @param id ID del registro de la lista de espera a eliminar.
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarDeListaEspera(@PathVariable Long id) {
        listaEsperaService.eliminarDeListaEspera(id);
    }
}
