package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloSinHorarioDTO;

import java.util.List;

public interface ModuloService {

    ModuloSinHorarioDTO listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente, Long id_asignatura);
}
