package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class AsignaturasResponse {

    private Long id;
    private String nombre;

    /* 
    private Long idPrograma;
    private String nombrePrograma;
    private Long idAsignatura;
    private String descripcion;
    */
    
}
