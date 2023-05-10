package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.dto.response.ServicioResponse;;

public final class ServicioMapper {
    
    private ServicioMapper(){
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ServicioResponse mapearResponse(Servicio servicio){
        
        return ServicioResponse.builder()
        .id(servicio.getId())
        .descripcion(servicio.getDescripcion())
        .build();
    }
}
