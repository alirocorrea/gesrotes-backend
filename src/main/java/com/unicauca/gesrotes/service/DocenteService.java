package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.DocenteResponse;

public interface DocenteService {
    DocenteResponse listarDocentesAsignatura(long id_asignatura) ;
}