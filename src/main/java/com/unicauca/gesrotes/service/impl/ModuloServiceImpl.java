package com.unicauca.gesrotes.service.impl;


import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.repository.DocenteRepository;
import com.unicauca.gesrotes.repository.ModuloRepository;
import com.unicauca.gesrotes.service.ModuloService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModuloServiceImpl implements ModuloService{

    private ModuloRepository modulosRepository;
    private DocenteRepository docentesRepository;
    //TODO:Manejar excepciones
    @Override
    public ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) {
        if(!docenteExiste(idDocente)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El Docente no existe"
            );
        }
        if (esValidoNombre(moduloRequest)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El nombre de Modulo ya existe"
            );
        }
        System.out.println("Guardando");
        Modulo modulo = ModuloMapper.mapearEntidadNombre(moduloRequest);
        return ModuloMapper.mapearResponse(modulosRepository.save(modulo));
    }
    
    private boolean esValidoNombre(ModuloRequest request) {
        if(modulosRepository.findByNombre(request.getNombre_modulo()).size() > 0){
            return false;
        }
        else{
            return true;
        }
        
    }

    private boolean docenteExiste(long idDocente){
        return docentesRepository.existsById(idDocente);
    }
   
    
}