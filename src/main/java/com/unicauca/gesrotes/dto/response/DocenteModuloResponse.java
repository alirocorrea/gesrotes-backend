package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocenteModuloResponse {
    private Long id;
    private String nombre;
}
