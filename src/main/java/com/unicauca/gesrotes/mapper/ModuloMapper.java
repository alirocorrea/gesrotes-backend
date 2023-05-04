package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.dto.ModuloDTO;

public final class ModuloMapper {
    
    private ModuloMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Modulo mapearEntidadNombre(ModuloRequest horarioRequest) {
        return Modulo.builder()
                .nombre(horarioRequest.getNombre_modulo())
                .build();
    }

    public static ModuloResponse mapearResponse(Modulo modulo) {
        return ModuloResponse.builder()
        .id(modulo.getId())
        .nombre_modulo(modulo.getNombre())
        .build();
    }

    public static ModuloDTO mapModulo(Modulo modulo){
        return ModuloDTO.builder()
                .id(modulo.getId())
                .nombre(modulo.getNombre())
                .build();
    }

}
