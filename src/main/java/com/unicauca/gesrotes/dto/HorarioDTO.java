package com.unicauca.gesrotes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorarioDTO {

    private Long id;
    private String descripcion;
}
