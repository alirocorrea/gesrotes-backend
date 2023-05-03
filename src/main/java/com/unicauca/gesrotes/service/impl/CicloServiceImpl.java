package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.common.sortDateCompare;
import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.response.CicloResponse;
import com.unicauca.gesrotes.dto.response.CicloResponseList;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.CicloListMapper;
import com.unicauca.gesrotes.mapper.CicloMapper;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.repository.CicloRepository;
import com.unicauca.gesrotes.service.CicloService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CicloServiceImpl implements CicloService{

    private CicloRepository ciclosRepository;
    private AsignaturaRepository asignaturasRepository;

    @Override
    public CicloResponseList listarCiclosAsignatura(long id_asignatura) {
        if(!asignaturaExiste(id_asignatura)){
            throw new ApplicationException("La Asignatura no existe");
        }
        
        Asignatura varAsignatura = asignaturasRepository.findById(id_asignatura).get();

        List<Ciclo> listaCiclosAsignaturas=new ArrayList<>();
        listaCiclosAsignaturas=ciclosRepository.findByAsignatura(varAsignatura);

        if(listaCiclosAsignaturas.size()==0){
            throw new ApplicationException("La Asignatura no tiene Ciclos asociados");
        }
        Collections.sort(listaCiclosAsignaturas, new sortDateCompare());
        List<CicloResponse> listaResultado=new ArrayList<>();
        for(Ciclo iCiclo: listaCiclosAsignaturas){
            listaResultado.add(CicloMapper.mapearResponse(iCiclo));
        }
        

        return CicloListMapper.mapearResponse(listaResultado);
    }
    
    private boolean asignaturaExiste(long id_asignatura){
        return asignaturasRepository.existsById(id_asignatura);
    }


}
