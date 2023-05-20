package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;

import com.unicauca.gesrotes.dto.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.dto.DocenteModuloDTO;

public interface ModuloService {

    ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) ;

    ModuloSinHorarioDTO listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente, Long id_asignatura);

    DocenteModuloDTO listarHorarios(Long id_Asignatura);

}
