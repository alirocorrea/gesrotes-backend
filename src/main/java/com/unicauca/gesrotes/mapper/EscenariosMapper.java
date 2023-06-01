package com.unicauca.gesrotes.mapper;

import java.util.Date;
import java.util.List;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.EscenariosDocumentosResponse;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import com.unicauca.gesrotes.domain.DocumentoEscenario;
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

    public static EscenariosDocumentosResponse mapeaResponse(Escenario pEscenario) {
        Date fechaActual = new Date();
        int documentosExpirados = 0;
        String info;
        List<DocumentoEscenario> documentoEscenarios = pEscenario.getDocumentosEscenario();
        if(documentoEscenarios.size()==0){
            info = "No existen documentos para este escenario";
        }
        else{
            for (DocumentoEscenario documentoEscenario : documentoEscenarios) {
                if(documentoEscenario.getVigencia().before(fechaActual)){
                    documentosExpirados++;
                }
            }
            info = "Documentos expirados: "+documentosExpirados;
        }
        return EscenariosDocumentosResponse.builder()
        .escenarios(EscenariosMapper.domainToDTO(pEscenario))
        .info(info)
        .build();
    }
}