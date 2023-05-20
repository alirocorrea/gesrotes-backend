package com.unicauca.gesrotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.dto.response.ServicioFullResponse;
import com.unicauca.gesrotes.dto.response.ServicioResponse;
import com.unicauca.gesrotes.mapper.ServicioFullMapper;
import com.unicauca.gesrotes.mapper.ServicioMapper;
import com.unicauca.gesrotes.repository.EscenarioRepository;
import com.unicauca.gesrotes.repository.ServicioRepository;
import com.unicauca.gesrotes.service.ServicioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ServicioServiceImpl implements ServicioService{

   
    private EscenarioRepository escenarioRepository;
    private ServicioRepository servicioRepository;

    @Override
    public ServicioFullResponse listarServiciosPorEscenario(long id) {
        
    
    if(!escenarioExiste(id)){
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "El escenario no existe."
        );
    }
    
    
    Escenario varEscenario = escenarioRepository.findById(id).get();

    

    List<Servicio> listaServicios=new ArrayList<>();
    listaServicios=servicioRepository.findByEscenario(varEscenario);
    
        
    List<ServicioResponse> listaResultado=new ArrayList<>();
    for(Servicio iServicio : listaServicios){
        listaResultado.add(ServicioMapper.mapearResponse(iServicio));
    }
    if(listaResultado.size()==0){
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "No se encontraron Servicios asociados."
        );
    }
    return ServicioFullMapper.mapearResponse(listaResultado);

    }

    private boolean escenarioExiste(long id) {
        return escenarioRepository.existsById(id);
    }
    
}
