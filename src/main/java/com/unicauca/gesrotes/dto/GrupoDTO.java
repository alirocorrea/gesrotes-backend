package com.unicauca.gesrotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({ "id", "numero_grupo", "estudiantes" })
public class GrupoDTO {

    private Long id;

    @JsonProperty("numero_grupo")
    private Integer numeroGrupo;

    private List<EstudianteDTO> estudiantes;
}
