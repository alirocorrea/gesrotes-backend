package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorarioResponse {

    private Long id;
    private String nombreHorario;
}
