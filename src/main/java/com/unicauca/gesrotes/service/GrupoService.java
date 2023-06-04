package com.unicauca.gesrotes.service;

import java.text.ParseException;
import java.util.List;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.response.GrupoResponse;

public interface GrupoService {

    List<Grupo> findByAsignatura(Asignatura id_asignatura);
    GrupoResponse registrarGrupo(Long l) throws ParseException;

}