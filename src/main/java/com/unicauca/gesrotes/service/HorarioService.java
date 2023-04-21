package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.domain.Horario;
import com.unicauca.gesrotes.dto.response.HorarioResponse;

import java.util.List;

public interface HorarioService {

    List<HorarioResponse> listaHorarioNoConfigurado(Long idDocente, Long idAsignatura);
}
