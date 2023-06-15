package com.unicauca.gesrotes.mapper;

import java.util.ArrayList;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.AsignaturaDTO;
import com.unicauca.gesrotes.dto.CiclosDTO;
import com.unicauca.gesrotes.dto.request.CicloRequest;
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
    public static Ciclo mapearCiclo(CicloRequest cicloRequest) {
        return Ciclo.builder()
                .fechaInicio(cicloRequest.getInicio())
                .fechaFin(cicloRequest.getFin())
                .build();
    }

    public static CiclosDTO toAsignaturaDTO(final Ciclo ciclos) {
        return CiclosDTO.builder()
            .idCiclos(ciclos.getId())
            .asignaciones(new ArrayList<>())
            .build();
            
    }
}