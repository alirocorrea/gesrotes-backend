package com.unicauca.gesrotes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.AsignaturaDTO;
import com.unicauca.gesrotes.mapper.AsignaturaMapper;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.service.AsignaturaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    private final AsignaturaRepository repository;
    private final AsignaturaMapper mapper;

    @Override
    public AsignaturaDTO getAsignaturas(Long id_programa) {
        List<Asignatura> asignaturas = repository.findAllByProgramaId(id_programa);
        
        System.out.println("Servicio: " + asignaturas.size());
        AsignaturaDTO asignaturaDTO = AsignaturaMapper.domainToDTO(asignaturas);
        return asignaturaDTO;
    }
    /* 
    public List<AsignaturasResponse> getAsignaturas(Long id_programa) {
        List<Asignatura> asignaturas = repository.findAllByProgramaId(id_programa);
        List<AsignaturasResponse> asignaturasResponses = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            AsignaturasResponse asignaturasResponse = mapper.domainToDTO(asignatura);
            asignaturasResponses.add(asignaturasResponse);                  
        }
        return asignaturasResponses;
    }
    */
}