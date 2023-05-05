package com.unicauca.gesrotes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.repository.EscenarioRepository;
import com.unicauca.gesrotes.service.IEscenariosService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EscenariosService implements IEscenariosService{

    private final EscenarioRepository repository;

    @Override
    public List<Escenario> getEscenarios() {
        try {
            return repository.findAll();
        } catch(Exception error) {
            System.out.println("Se ha presentado un error : " + error);
        }
        return null;
    }
    
}
