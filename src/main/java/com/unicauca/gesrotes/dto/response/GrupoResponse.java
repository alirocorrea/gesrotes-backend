package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.unicauca.gesrotes.domain.Estudiante;

@Data
@Builder
public class GrupoResponse {
    private Long id;
    private int numero_grupo;
    private List<Estudiante> asignaciones;
}
