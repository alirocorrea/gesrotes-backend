package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.gesrotes.dto.response.EscenariosDocumentosResponse;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import com.unicauca.gesrotes.mapper.EscenariosMapper;
import com.unicauca.gesrotes.service.EscenarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.repository.EscenarioRepository;

@AllArgsConstructor
@Service
public class EscenarioServiceImpl implements EscenarioService {

    private EscenarioRepository repository;

    @Override
    public List<EscenariosResponse> getEscenarios() {
        List<Escenario> escenarios = repository.findAll();
        List<EscenariosResponse> escenariosResponses = new ArrayList<>();
        for (Escenario escenario : escenarios) {
            EscenariosResponse escenariosResponse = EscenariosMapper.domainToDTO(escenario);
            escenariosResponses.add(escenariosResponse);
        }
        return escenariosResponses;

    }

    @Override
    public List<EscenariosDocumentosResponse> getEscenariosDocumentos() {
        List<Escenario> escenarios = repository.findAll();

        List<EscenariosDocumentosResponse> vEscenariosDocumentosResponses =  new ArrayList<>();
        for (Escenario escenario : escenarios) {
            EscenariosDocumentosResponse vEscenariosDocumentosResponse
             = EscenariosMapper.mapeaResponse(escenario);
            vEscenariosDocumentosResponses.add(vEscenariosDocumentosResponse);
        }
        return vEscenariosDocumentosResponses;
    }

  
    
}
