package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.domain.Horario;

import java.util.List;

public interface HorarioService {

    List<Horario> listaHorarioNoConfigurado(Long idDocente, Long idAsignatura);
}
