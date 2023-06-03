package com.unicauca.gesrotes.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponse;

public final class CicloMapper {
    
    private CicloMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static CicloResponse mapearResponse(Ciclo ciclo) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return CicloResponse.builder()
        .id(ciclo.getId())
        .inicio(formatter.format(ciclo.getFechaInicio()))
        .fin(formatter.format(ciclo.getFechaFin()))
        .build();
    }
    public static Ciclo mapearCiclo(CicloRequest cicloRequest) {
        return Ciclo.builder()
                .fechaInicio(cicloRequest.getInicio())
                .fechaFin(cicloRequest.getFin())
                .build();
    }
}