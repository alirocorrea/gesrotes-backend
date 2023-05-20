package com.unicauca.gesrotes.service;

import java.util.List;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;

public interface GrupoService {

    List<Grupo> findByAsignatura(Asignatura id_asignatura);

}