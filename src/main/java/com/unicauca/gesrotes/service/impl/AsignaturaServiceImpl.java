package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;
import com.unicauca.gesrotes.mapper.AsignaturaMapper;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.service.AsignaturaService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    private final AsignaturaRepository repository;

    @Override
    public List<AsignaturasResponse> getAsignaturas() {
        List<Asignatura> asignaturas = repository.findAll();
        List<AsignaturasResponse> asignaturasResponses = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            AsignaturasResponse asignaturasResponse = AsignaturaMapper.domainToDTO(asignatura);
            asignaturasResponses.add(asignaturasResponse);                  
        }
        return asignaturasResponses;
    }
}
