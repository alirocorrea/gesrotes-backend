package com.unicauca.gesrotes.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.AsignaturaDTO;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;
import com.unicauca.gesrotes.dto.response.ProgramaResponse;

@Component
public final class AsignaturaMapper {

    public static AsignaturaDTO domainToDTO(List<Asignatura> asignaturas){
        List<AsignaturasResponse> asignaturasResponses =  new ArrayList<>();
        List<ProgramaResponse> programasResponses = new ArrayList<>();

        for(Asignatura a : asignaturas){
            AsignaturasResponse asignaturaRes = AsignaturasResponse.builder()
            .id(a.getId())
            .nombre(a.getDescripcion())
            .build();
            asignaturasResponses.add(asignaturaRes);

        }

        
        for(Asignatura a : asignaturas){
            ProgramaResponse programaRes = ProgramaResponse.builder()
            .nombre(a.getPrograma().getNombre())
            .asignaturas(asignaturasResponses)
            .build();
            programasResponses.add(programaRes);
        }

        AsignaturaDTO asignaturaDTO = AsignaturaDTO.builder()
        .programas(programasResponses)
        .build();
        System.out.println("Mapper: " + asignaturaDTO);
        return asignaturaDTO;


    }
    
}
