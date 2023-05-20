package com.unicauca.gesrotes.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorarioDTO {

    private Long id;

    private String dia;
    private Date horaInicio;
    private Date horaFin;
    
}
