package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocenteResponse {
    private Long id;
    private String nombre;
    //private String ruta_foto;
    private String info;
}
