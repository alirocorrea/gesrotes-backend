package com.unicauca.gesrotes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.service.GrupoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService{

    private GrupoRepository grupoRepository;

    @Override
    public List<Grupo> findByAsignatura(Asignatura asignatura) {
        return grupoRepository.findByAsignatura(asignatura);
    }
    
}
