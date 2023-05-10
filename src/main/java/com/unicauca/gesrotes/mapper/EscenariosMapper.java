package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import lombok.Getter;
import com.unicauca.gesrotes.domain.Escenario;

public final class EscenariosMapper {

    private EscenariosMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static EscenariosResponse domainToDTO(Escenario escenario) {
        EscenariosResponse escenarioResponse = new EscenariosResponse();
        escenarioResponse.setId(escenario.getId());
        escenarioResponse.setNombre(escenario.getNombre());
        escenarioResponse.setDireccion(escenario.getDireccion());
        return escenarioResponse;
    }
}