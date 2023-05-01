package com.unicauca.gesrotes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateHorarioRequest {

    @NotBlank
    private String dia;

    @NotNull
    @JsonProperty("hora_inicio")
    private Integer horaInicio;

    @NotNull
    @JsonProperty("hora_fin")
    private Integer horaFin;

    @NotNull
    @JsonProperty("id_escenario")
    private Long idEscenario;

    @NotNull
    @JsonProperty("id_servicio")
    private Long idServicio;
}
