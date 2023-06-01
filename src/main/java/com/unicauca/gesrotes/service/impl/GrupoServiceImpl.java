package com.unicauca.gesrotes.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.response.GrupoResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.GrupoMapper;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.service.GrupoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService{

    private GrupoRepository grupoRepository;
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Grupo> findByAsignatura(Asignatura asignatura) {
        return grupoRepository.findByAsignatura(asignatura);
    }

    @Override
    public GrupoResponse registrarGrupo(Long l) throws ParseException {
        if(!asignaturaExiste(l)){
            
            throw new ApplicationException("La Asignatura no existe");
        }

        Asignatura asignatura=asignaturaRepository.findById(l).get();
        Grupo grupo = GrupoMapper.mapearGrupo();
        grupo.setAsignatura(asignatura);

        List<Grupo> listaAsociados=grupoRepository.findByAsignatura(asignatura);
        System.out.println("***AQUI:1");

        return GrupoMapper.mapearResponse(grupoRepository.save(grupo), listaAsociados.size()+1);
    }

    private boolean asignaturaExiste(long idAsignatura){
        return asignaturaRepository.existsById(idAsignatura);
    }
    
}
