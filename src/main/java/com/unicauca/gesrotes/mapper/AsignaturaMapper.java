package com.unicauca.gesrotes.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.AsignaturaDTO;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;

@Component
public final class AsignaturaMapper {

    public static AsignaturasResponse domainToDTO(Asignatura asignatura){
        AsignaturasResponse asignaturaResponse = new AsignaturasResponse();
        asignaturaResponse.setIdPrograma(asignatura.getPrograma().getId());
        asignaturaResponse.setPrograma(asignatura.getPrograma().getNombre());
        asignaturaResponse.setId(asignatura.getId());
        asignaturaResponse.setNombre(asignatura.getDescripcion());
        return asignaturaResponse;

    }
    
}
