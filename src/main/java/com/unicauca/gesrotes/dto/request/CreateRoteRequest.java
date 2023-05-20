package com.unicauca.gesrotes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateRoteRequest {

    @NotNull
    @JsonProperty("id_grupo")
    private Long idGrupo;

    @NotNull
    @JsonProperty("id_ciclo")
    private Long idCiclo;

    @NotNull
    @JsonProperty("id_horario")
    private Long idHorarioModulo;
}
