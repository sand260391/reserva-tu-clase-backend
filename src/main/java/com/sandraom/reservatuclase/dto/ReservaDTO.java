package com.sandraom.reservatuclase.dto;

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
}
