package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Configuracion;
import com.unicauca.gesrotes.dto.response.PingResponse;

import java.time.LocalDateTime;

public final class ConfiguracionMapper {

    private ConfiguracionMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static PingResponse toPingResponse(final Configuracion configuracion) {
        return PingResponse.builder()
                .message(configuracion.getMensajeInformacion())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
