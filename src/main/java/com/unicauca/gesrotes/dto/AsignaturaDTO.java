package com.unicauca.gesrotes.dto;

import java.util.List;

import com.unicauca.gesrotes.dto.response.AsignaturasResponse;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AsignaturaDTO {

    private List<AsignaturasResponse> asignaturas;
    private String programa;
    private Long id;
    private String nombre;
    
}
