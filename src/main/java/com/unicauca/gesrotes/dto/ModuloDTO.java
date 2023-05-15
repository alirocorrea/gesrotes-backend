package com.unicauca.gesrotes.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ModuloDTO {

    private Long id;
    private String nombre;
    private List<HorarioDTO> horarios;
}
