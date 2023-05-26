package com.unicauca.gesrotes.mapper;

import org.springframework.stereotype.Component;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;

@Component
public class AsignaturaMapper {

    public  AsignaturasResponse domainToDTO(Asignatura asignatura){
        AsignaturasResponse asignaturaResponse = new AsignaturasResponse();
        asignaturaResponse.setIdPrograma(asignatura.getPrograma().getId());
        asignaturaResponse.setNombrePrograma(asignatura.getPrograma().getNombre());
        asignaturaResponse.setIdAsignatura(asignatura.getId());
        asignaturaResponse.setDescripcion(asignatura.getDescripcion());
        return asignaturaResponse;

    }
    
}
