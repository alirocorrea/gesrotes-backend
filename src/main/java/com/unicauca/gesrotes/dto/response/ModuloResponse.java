package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuloResponse {
    private Long id;
    private String nombre_modulo;
}