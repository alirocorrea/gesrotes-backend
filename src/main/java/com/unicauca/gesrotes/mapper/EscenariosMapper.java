package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import org.springframework.stereotype.Component;
import com.unicauca.gesrotes.domain.Escenario;

@Component
public class EscenariosMapper {
    public EscenariosResponse domainToDTO(Escenario escenario) {
        EscenariosResponse escenarioResponse = new EscenariosResponse();
        escenarioResponse.setId(escenario.getId());
        escenarioResponse.setNombre(escenario.getNombre());
        escenarioResponse.setDireccion(escenario.getDireccion());
        return escenarioResponse;
    }
}