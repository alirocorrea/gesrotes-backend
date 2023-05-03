package com.unicauca.gesrotes.service.impl;


import org.springframework.stereotype.Service;


import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
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
    @Override
    public ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) {
        if(!docenteExiste(idDocente)){
            
            throw new ApplicationException("El Docente no existe");
        }
        Docente varDocente=docentesRepository.findById(idDocente).get();
        if (!esValidoNombre(moduloRequest)) {
            throw new ApplicationException("El Nombre de Modulo no es valido");
        }
        Modulo modulo = ModuloMapper.mapearEntidadNombre(moduloRequest);
        modulo.setDocente(varDocente);
        return ModuloMapper.mapearResponse(modulosRepository.save(modulo));
    }
    
    private boolean esValidoNombre(ModuloRequest request) {
        if(modulosRepository.findByNombre(request.getNombre_modulo()).size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean docenteExiste(long idDocente){
        return docentesRepository.existsById(idDocente);
    }

}