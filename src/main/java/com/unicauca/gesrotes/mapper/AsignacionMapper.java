package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Asignacion;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.dto.AsignacionDTO;

import java.util.ArrayList;

public final class AsignacionMapper {

    private AsignacionMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static AsignacionDTO toAsignacionDTO(final Asignacion asignacion) {
        return AsignacionDTO.builder()
                .idCiclo(asignacion.getCiclo().getId())
                .idGrupo(asignacion.getGrupo().getId())
                .docentes(new ArrayList<>())
                .build();
    }

    public static Asignacion createAsignacion(final Grupo grupo, final Ciclo ciclo, final HorarioModulo horarioModulo) {
        return Asignacion.builder()
                .grupo(grupo)
                .ciclo(ciclo)
                .horarioModulo(horarioModulo)
                .build();
    }

}
