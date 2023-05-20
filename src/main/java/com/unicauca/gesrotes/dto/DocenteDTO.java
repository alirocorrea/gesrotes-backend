package com.unicauca.gesrotes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class DocenteDTO {

    private Long id;
    @JsonProperty("docente")
    private String nombre;
    private List<ModuloDTO> modulos;
}
