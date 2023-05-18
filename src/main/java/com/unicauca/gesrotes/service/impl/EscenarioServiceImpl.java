package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import com.unicauca.gesrotes.mapper.EscenariosMapper;
import com.unicauca.gesrotes.service.EscenarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.repository.EscenarioRepository;



@RequiredArgsConstructor
@Service
public class EscenarioServiceImpl implements EscenarioService {

    private final EscenarioRepository repository;
    private final EscenariosMapper mapper;

    @Override
    public List<EscenariosResponse> getEscenarios() {
        List<Escenario> escenarios = repository.findAll();
        List<EscenariosResponse> escenariosResponses = new ArrayList<>();
        for (Escenario escenario : escenarios) {
            EscenariosResponse escenariosResponse = mapper.domainToDTO(escenario);
            escenariosResponses.add(escenariosResponse);
        }
        return escenariosResponses;

    }
    
}
