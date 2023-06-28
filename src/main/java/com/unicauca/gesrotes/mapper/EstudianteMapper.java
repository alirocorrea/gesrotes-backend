package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;

import com.unicauca.gesrotes.domain.Estudiante;
import com.unicauca.gesrotes.domain.Persona;
import com.unicauca.gesrotes.dto.EstudianteDTO;

public final class EstudianteMapper {

    private EstudianteMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static EstudianteDTO toEstudianteDTO(final Estudiante estudiante) {
        Persona persona = estudiante.getPersona();
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(persona.getNombre() + " " + persona.getApellido())
                .build();
    }

}
