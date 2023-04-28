package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.ModuloDTO;

import java.util.List;

public interface ModuloService {

    List<ModuloDTO> listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente,Long id_asignatura);
}
