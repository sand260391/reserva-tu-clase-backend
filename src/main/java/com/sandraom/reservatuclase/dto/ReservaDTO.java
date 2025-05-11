package com.sandraom.reservatuclase.dto;

/**
 * DTO para representar los detalles de una reserva.
 */

import java.time.LocalDateTime;

import com.sandraom.reservatuclase.model.Usuario;

import lombok.Data;

@Data
public class ReservaDTO {
    private Long id;
    private LocalDateTime claseHoraInicio;
    private LocalDateTime claseHoraFin;
    private String claseNombre;
    private Usuario claseMonitor;
    private String tipoClaseNombre;
    private int plazasReservadas;
    private int plazasTotales;
    private int longitudListaEspera;
    private String nombreCliente;
    private String apellidosCliente;
    private LocalDateTime fechaReserva;
}
