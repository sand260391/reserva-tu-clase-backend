package com.sandraom.reservatuclase.dto;

import java.time.LocalDateTime;

import com.sandraom.reservatuclase.model.Usuario;

import lombok.Data;

/**
 * DTO para representar los detalles de una lista de espera.
 */
@Data
public class ListaEsperaDTO {
    private Long id;
    private LocalDateTime claseHoraInicio;
    private LocalDateTime claseHoraFin;
    private String claseNombre;
    private Usuario claseMonitor;
    private String tipoClaseNombre;
    private int plazasReservadas;
    private int plazasTotales;
    private int longitudListaEspera;
    private int posicionEnListaEspera; // Nueva propiedad para la posición en la lista de espera
}
