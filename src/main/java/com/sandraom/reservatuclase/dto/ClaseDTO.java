package com.sandraom.reservatuclase.dto;

/**
 * DTO para representar los detalles de una clase.
 */
import lombok.Data;
import java.time.LocalDateTime;
import com.sandraom.reservatuclase.model.TipoClase;
import com.sandraom.reservatuclase.model.Usuario;

@Data
public class ClaseDTO {
    private Long id;
    private String nombre;
    private TipoClase tipoClase;
    private Usuario monitor;
    private String sala;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private int capacidadMaxima;
    private int plazasReservadas;
    private int longitudListaEspera;
}
