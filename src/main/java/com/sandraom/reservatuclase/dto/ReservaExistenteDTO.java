package com.sandraom.reservatuclase.dto;

import lombok.Data;

@Data
public class ReservaExistenteDTO {
    private Long id;
    private Long usuarioId;
    private Long claseId;
}
