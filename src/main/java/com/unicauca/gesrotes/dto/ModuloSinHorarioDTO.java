package com.unicauca.gesrotes.dto;

import com.unicauca.gesrotes.dto.response.ModuloResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModuloSinHorarioDTO {

    private List<ModuloResponse> modulos_sin_horarios;
}
