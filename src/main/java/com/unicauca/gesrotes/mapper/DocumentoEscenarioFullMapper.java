package com.unicauca.gesrotes.mapper;

import java.util.List;

import com.unicauca.gesrotes.dto.response.EscenariosDocumentosFullResponse;
import com.unicauca.gesrotes.dto.response.EscenariosDocumentosResponse;

public class DocumentoEscenarioFullMapper {

    public static EscenariosDocumentosFullResponse mapeaResponse(List<EscenariosDocumentosResponse> pDocumentosResponses) {
        return EscenariosDocumentosFullResponse.builder()
        .escenarios(pDocumentosResponses)
        .build();
    }
}
