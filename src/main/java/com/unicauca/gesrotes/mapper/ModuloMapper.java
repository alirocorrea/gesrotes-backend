package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;

public final class ModuloMapper {
    
    private ModuloMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Modulo mapearEntidadNombre(ModuloRequest horarioRequest) {
        return Modulo.builder()
                .nombre(horarioRequest.getNombre_modulo())
                .build();
    }

    public static ModuloResponse mapearResponse(Modulo horario) {
        return ModuloResponse.builder().id(horario.getId()).build();
    }

}