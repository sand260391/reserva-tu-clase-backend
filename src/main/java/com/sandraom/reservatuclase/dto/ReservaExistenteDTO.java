package com.sandraom.reservatuclase.dto;

/**
 * DTO para representar una reserva existente.
 */
import lombok.Data;

@Data
public class ReservaExistenteDTO {
    private Long id;
    private Long usuarioId;
    private Long claseId;
}
