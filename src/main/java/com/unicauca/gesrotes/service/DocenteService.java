package com.unicauca.gesrotes.service;

import java.util.List;

import com.unicauca.gesrotes.dto.response.DocenteFullResponse;
import com.unicauca.gesrotes.dto.response.DocenteResponse;

public interface DocenteService {
    DocenteFullResponse listarDocentesAsignatura(long id_asignatura) ;
}