package com.unicauca.gesrotes.service;

import java.util.List;

import com.unicauca.gesrotes.dto.response.EscenariosDocumentosResponse;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;

public interface EscenarioService {

    List<EscenariosResponse> getEscenarios();

    List<EscenariosDocumentosResponse> getEscenariosDocumentos();
}


