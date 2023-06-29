package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.CiclosDTO;
import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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


    public static CiclosDTO toAsignaturaDTO(final Ciclo ciclos) {
        return CiclosDTO.builder()
            .idCiclos(ciclos.getId())
            .asignaciones(new ArrayList<>())
            .build();
            
    }

}