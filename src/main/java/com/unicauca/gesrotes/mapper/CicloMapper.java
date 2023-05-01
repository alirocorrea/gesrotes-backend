package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.response.CicloResponse;

public final class CicloMapper {
    
    private CicloMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static CicloResponse mapearResponse(Ciclo ciclo) {
        return CicloResponse.builder()
        .id(ciclo.getId())
        .inicio(FechaMapper.mapearResponse(ciclo.getFechaInicio()))
        .fin(FechaMapper.mapearResponse(ciclo.getFechaFin()))
        .build();
    }

}