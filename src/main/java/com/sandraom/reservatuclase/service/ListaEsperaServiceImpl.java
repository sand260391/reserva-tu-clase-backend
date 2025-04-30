package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.ListaEspera;
import com.sandraom.reservatuclase.model.Usuario;
import com.sandraom.reservatuclase.model.Clase;
import com.sandraom.reservatuclase.repository.ListaEsperaRepository;
import com.sandraom.reservatuclase.repository.UsuarioRepository;
import com.sandraom.reservatuclase.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListaEsperaServiceImpl implements ListaEsperaService {

    @Autowired
    private ListaEsperaRepository listaEsperaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClaseRepository claseRepository;

    /**
     * Obtiene la lista de espera de una clase específica, ordenada por posición.
     *
     * @param claseId ID de la clase para la cual se desea obtener la lista de espera.
     * @return Lista de espera ordenada por posición.
     */
    @Override
    public List<ListaEspera> obtenerListaEsperaPorClase(Long claseId) {
        // Llama al repositorio para obtener la lista de espera ordenada por posición.
        return listaEsperaRepository.findByClaseIdOrderByPosicionAsc(claseId);
    }

    /**
     * Agrega un cliente a la lista de espera de una clase específica.
     *
     * @param clienteId ID del cliente que se desea agregar.
     * @param claseId   ID de la clase a la cual se desea agregar el cliente.
     * @return El registro de lista de espera creado.
     */
    @Override
    public ListaEspera agregarAListaEspera(Long clienteId, Long claseId) {
        // Busca el cliente por su ID. Lanza una excepción si no se encuentra.
        Usuario cliente = usuarioRepository.findById(clienteId).orElseThrow(/* Excepción predeterminada */);

        // Busca la clase por su ID. Lanza una excepción si no se encuentra.
        Clase clase = claseRepository.findById(claseId).orElseThrow(/* Excepción predeterminada */);

        // Calcula la posición en la lista de espera como el tamaño actual + 1.
        int posicion = listaEsperaRepository.findByClaseIdOrderByPosicionAsc(claseId).size() + 1;

        // Crea un nuevo registro de lista de espera con los datos proporcionados.
        ListaEspera listaEspera = new ListaEspera();
        listaEspera.setCliente(cliente); // Asigna el cliente al registro.
        listaEspera.setClase(clase); // Asigna la clase al registro.
        listaEspera.setFechaInscripcion(LocalDateTime.now()); // Registra la fecha de inscripción.
        listaEspera.setPosicion(posicion); // Asigna la posición calculada.

        // Guarda y retorna el registro creado.
        return listaEsperaRepository.save(listaEspera);
    }

    /**
     * Elimina un registro de la lista de espera por su ID.
     *
     * @param id ID del registro de lista de espera que se desea eliminar.
     */
    @Override
    public void eliminarDeListaEspera(Long id) {
        // Llama al repositorio para eliminar el registro por su ID.
        listaEsperaRepository.deleteById(id);
    }
}
