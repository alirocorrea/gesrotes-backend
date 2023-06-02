package com.unicauca.gesrotes.dto.response;

import java.util.List;

import com.unicauca.gesrotes.domain.DocumentoEscenario;

import lombok.Data;

@Data
public class EscenariosResponse {
    private Long id;
    private String nombre;
    private String direccion;
}