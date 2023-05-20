package com.unicauca.gesrotes.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorarioModuloDTO {
    
    private String codigoAsignatura;
    private String descripcionAsignatura;
    private String nombreModulo;
    private String dia;
    private Date horaInicio;
    private Date horaFin;
    private String nombreEscenario;
    private String descripcionServicio;
    
}
