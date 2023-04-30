package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.dto.response.DocenteResponse;

public final class DocenteMapper {
    
    private DocenteMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static DocenteResponse mapearResponse(Docente docente) {
        //TODO:mostrar info si tiene horarios sin configurar
        //EJM// info:2 horarios sin configurar
        return DocenteResponse.builder()
        .id(docente.getId())
        .nombre(docente.getPersona().getNombre()+ " " + docente.getPersona().getApellido())
        .info("TODO:Chequeos")
        .build();
    }

}