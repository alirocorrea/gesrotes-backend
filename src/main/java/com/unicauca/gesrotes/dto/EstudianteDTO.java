package com.unicauca.gesrotes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstudianteDTO {

    private Long id;
    private String nombre;
}
