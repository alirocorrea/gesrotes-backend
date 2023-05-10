package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.DocenteFullResponse;

public interface DocenteService {
    DocenteFullResponse listarDocentesAsignatura(long id_asignatura) ;
}