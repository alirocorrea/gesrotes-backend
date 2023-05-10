package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.dto.response.DocenteFullResponse;
import com.unicauca.gesrotes.dto.response.DocenteResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.DocenteFullMapper;
import com.unicauca.gesrotes.mapper.DocenteMapper;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.repository.DocenteRepository;
import com.unicauca.gesrotes.service.DocenteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocenteServiceImpl implements DocenteService{

    private DocenteRepository docentesRepository;
    private AsignaturaRepository asignaturasRepository;

    @Override
    public DocenteFullResponse listarDocentesAsignatura(long id_asignatura) {
        if(!asignaturaExiste(id_asignatura)){
            throw new ApplicationException("La Asignatura no existe");
        }
        
        Asignatura varAsignatura = asignaturasRepository.findById(id_asignatura).get();

        List<Docente> listaDocentesAsignaturas=new ArrayList<>();
        listaDocentesAsignaturas=docentesRepository.findByAsignaturas(varAsignatura);
        
        List<DocenteResponse> listaResultado=new ArrayList<>();
        for(Docente iDocente : listaDocentesAsignaturas){
            listaResultado.add(DocenteMapper.mapearResponse(iDocente));
        }
        if(listaResultado.size()==0){
            throw new ApplicationException("No se encontraron docentes asociados");
        }
        return DocenteFullMapper.mapearResponse(listaResultado);
    }
    
    private boolean asignaturaExiste(long id_asignatura){
        return asignaturasRepository.existsById(id_asignatura);
    }


}
