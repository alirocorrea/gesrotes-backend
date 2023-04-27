package com.unicauca.gesrotes.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuloRequest {
    private String nombre_modulo;

    @JsonCreator
    public ModuloRequest(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }
}