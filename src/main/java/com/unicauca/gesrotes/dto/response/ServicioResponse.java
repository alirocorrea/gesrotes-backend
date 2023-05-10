package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicioResponse {
    private Long id;
    private String descripcion;
}
