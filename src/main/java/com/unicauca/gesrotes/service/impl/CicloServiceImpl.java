package com.unicauca.gesrotes.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.common.sortDateCompare;
import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.dto.request.CicloRequest;
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

    @Override
    public CicloResponseList registrarCiclo(CicloRequest cicloRequest, long id_asignatura) {
        if(!asignaturaExiste(id_asignatura)){
            throw new ApplicationException("La Asignatura no existe");
        }
        Asignatura varAsignatura=asignaturasRepository.findById(id_asignatura).get();
        //inicio<fin
        if(cicloRequest.getInicio().before(cicloRequest.getFin())==false){
            throw new ApplicationException("La fecha de inicio debe ser menor a la de fin");
        }
        //no existe un ciclo exactamente igual

        List<Ciclo> listaCiclosAsignaturas=new ArrayList<>();
        listaCiclosAsignaturas=ciclosRepository.findByAsignatura(varAsignatura);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        for(Ciclo iCiclo: listaCiclosAsignaturas){
            if(dateFormat.format(cicloRequest.getInicio()).equals(iCiclo.getFechaInicio().toString())&& dateFormat.format(cicloRequest.getFin()).equals(iCiclo.getFechaFin().toString())){
                throw new ApplicationException("Existe un ciclo con el mismo horario");
            }
        }
        //Mapeamos request a obj ciclo y guardamos
        Ciclo ciclo = CicloMapper.mapearCiclo(cicloRequest);
        ciclo.setAsignatura(varAsignatura);
        ciclosRepository.save(ciclo);
        
        //Retornamos la lista de Ciclos en asignatura
        List<Ciclo> listaCiclosAsignaturas2=new ArrayList<>();
        listaCiclosAsignaturas2=ciclosRepository.findByAsignatura(varAsignatura);
        Collections.sort(listaCiclosAsignaturas2, new sortDateCompare());
        List<CicloResponse> listaResultado=new ArrayList<>();
        for(Ciclo iCiclo: listaCiclosAsignaturas2){
            listaResultado.add(CicloMapper.mapearResponse(iCiclo));
        }
        
        return CicloListMapper.mapearResponse(listaResultado);
    }


}
