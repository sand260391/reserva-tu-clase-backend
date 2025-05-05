package com.sandraom.reservatuclase.service;

import com.sandraom.reservatuclase.model.ListaEspera;
import com.sandraom.reservatuclase.model.Notificacion;
import com.sandraom.reservatuclase.model.Reserva;
import com.sandraom.reservatuclase.model.Usuario;
import com.sandraom.reservatuclase.repository.ListaEsperaRepository;
import com.sandraom.reservatuclase.repository.NotificacionRepository;
import com.sandraom.reservatuclase.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz ReservaService.
 * Proporciona la lógica de negocio para la gestión de reservas en el sistema.
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ListaEsperaRepository listaEsperaRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    /**
     * Obtiene las reservas realizadas por un cliente específico.
     *
     * @param clienteId ID del cliente.
     * @return Lista de reservas asociadas al cliente.
     */
    @Override
    public List<Reserva> obtenerReservasPorCliente(Long clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    /**
     * Crea una nueva reserva.
     *
     * @param reserva Objeto de tipo Reserva que contiene los datos de la reserva.
     * @return La reserva creada.
     */
    @Override
    public Reserva crearReserva(Reserva reserva) {
        // Establece la fecha actual como fecha de la reserva
        reserva.setFechaReserva(LocalDateTime.now());
        return reservaRepository.save(reserva);
    }

    /**
     * Cancela una reserva existente y promueve al primer usuario en la lista de espera.
     *
     * @param id ID de la reserva a cancelar.
     */
    @Override
    public void cancelarReserva(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            Reserva reserva = reservaOptional.get();
            reservaRepository.delete(reserva);

            // Promover al primer usuario en la lista de espera
            List<ListaEspera> listaEspera = listaEsperaRepository
                    .findByClaseIdOrderByPosicionAsc(reserva.getClase().getId());
            if (!listaEspera.isEmpty()) {
                ListaEspera primerEnLista = listaEspera.get(0);
                Usuario clientePromovido = primerEnLista.getCliente();

                // Crear una nueva reserva para el usuario promovido
                Reserva nuevaReserva = new Reserva();
                nuevaReserva.setClase(reserva.getClase());
                nuevaReserva.setCliente(clientePromovido);
                reservaRepository.save(nuevaReserva);

                // Eliminar al usuario promovido de la lista de espera
                listaEsperaRepository.delete(primerEnLista);

                // Crear una nueva notificación para el usuario promovido
                Notificacion nuevaNotificacion = new Notificacion();
                nuevaNotificacion.setCliente(clientePromovido);
                nuevaNotificacion
                        .setMensaje("¡Ya puedes asistir a la clase de " + reserva.getClase().getNombre() + "!");
                notificacionRepository.save(nuevaNotificacion);
            }
        }
    }

    /**
     * Obtiene las reservas asociadas a una clase específica.
     *
     * @param claseId ID de la clase.
     * @return Lista de reservas asociadas a la clase.
     */
    @Override
    public List<Reserva> obtenerReservasPorClase(Long claseId) {
        return reservaRepository.findByClaseId(claseId);
    }

    /**
     * Obtiene una reserva específica para un cliente y una clase.
     *
     * @param clienteId ID del cliente.
     * @param claseId ID de la clase.
     * @return El objeto Reserva si existe, null en caso contrario.
     */
    @Override
    public Reserva obtenerReservaPorClienteYClase(Long clienteId, Long claseId) {
        return reservaRepository.findByClienteIdAndClaseId(clienteId, claseId).orElse(null);
    }
}
