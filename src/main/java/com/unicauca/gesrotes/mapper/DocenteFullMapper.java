package com.unicauca.gesrotes.mapper;

import java.util.List;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.DocenteFullResponse;
import com.unicauca.gesrotes.dto.response.DocenteResponse;

public final class DocenteFullMapper {
    
    private DocenteFullMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static DocenteFullResponse mapearResponse(List<DocenteResponse>  parDocentes) {
        //TODO:Contrar profesores sin horarios por configurar
        //EJM// info:Faltan 2 Profesores por registrar horario
        return DocenteFullResponse.builder()
        .docentes(parDocentes)
        .info("TODO:Chequeos")
        .build();
    }

}