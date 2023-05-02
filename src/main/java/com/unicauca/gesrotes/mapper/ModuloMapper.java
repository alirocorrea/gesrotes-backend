package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.response.ModuloDTO;

public final class ModuloMapper {

    private  ModuloMapper(){
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ModuloDTO mapModulo(Modulo modulo){
        return ModuloDTO.builder()
                .id(modulo.getId())
                .nombre(modulo.getNombre())
                .build();
    }
}
