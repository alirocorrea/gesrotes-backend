package com.unicauca.gesrotes.dto.response;

import com.unicauca.gesrotes.dto.HorarioDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateHorarioResponse {

    private Long id;
    private String nombre;
    private List<HorarioDTO> horario;
    private String nombreEscenario;
    private String descripcion;
}
