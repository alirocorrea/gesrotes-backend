package com.unicauca.gesrotes.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorariosModulosDTO {

    private List<ModuloDTO> modulos;
    /* 
    private String codigoAsignatura;
    private String descripcionAsignatura;
    private String nombreModulo;
    private String dia;
    private Date horaInicio;
    private Date horaFin;
    private String nombreEscenario;
    private String descripcionServicio;
    
    */
}
