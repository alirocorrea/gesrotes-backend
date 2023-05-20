package com.unicauca.gesrotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AsignacionDTO {

    @JsonProperty("id_grupo")
    private Long idGrupo;

    @JsonProperty("id_ciclo")
    private Long idCiclo;

    private List<DocenteDTO> docentes;
}
