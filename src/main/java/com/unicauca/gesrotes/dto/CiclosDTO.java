package com.unicauca.gesrotes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicauca.gesrotes.dto.response.ListaAsignacionesResponse;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CiclosDTO {

    @JsonProperty("fk_id_asignaturascic")
    private List<ListaAsignacionesResponse> asignaciones;
    private Long idCiclos;
    
}
