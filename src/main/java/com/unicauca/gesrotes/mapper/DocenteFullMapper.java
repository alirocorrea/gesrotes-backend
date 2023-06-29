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
        int counterPersonasPorRegistrar=0;
        for(DocenteResponse iDocenteResponse : parDocentes){
            if(iDocenteResponse.getInfo() != null){
                counterPersonasPorRegistrar++;
            }
        }
        return DocenteFullResponse.builder()
        .docentes(parDocentes)
        .info("Faltan "+counterPersonasPorRegistrar+" Personas por registrar Horarios")
        .build();
    }

}