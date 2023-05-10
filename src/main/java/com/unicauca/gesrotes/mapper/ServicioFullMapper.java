package com.unicauca.gesrotes.mapper;

import java.util.List;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.ServicioFullResponse;
import com.unicauca.gesrotes.dto.response.ServicioResponse;

public class ServicioFullMapper {
    
    private ServicioFullMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }



    public static ServicioFullResponse mapearResponse(
            List<ServicioResponse> listaResultado) {
        return ServicioFullResponse.builder()
        .servicios(listaResultado)
        .build();
    }
}
