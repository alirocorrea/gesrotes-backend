package com.unicauca.gesrotes.service;

import java.text.ParseException;

import com.unicauca.gesrotes.dto.response.GrupoResponse;
import com.unicauca.gesrotes.dto.response.ListarGruposResponse;

public interface GrupoService {

    ListarGruposResponse getGruposAsignatura(final Long idAsignatura);

    GrupoResponse registrarGrupo(Long l) throws ParseException;

    void eliminarGrupo(Long id_grupo);

    void retirarEstudiante(Long id_estudiante, Long id_grupo);
}