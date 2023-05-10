package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.common.Util;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.HorarioDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class HorarioMapper {

    private HorarioMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static CreateHorarioResponse toCreateHorarioResponse (final Modulo modulo, final List<HorarioDTO> horarios) {
        return CreateHorarioResponse.builder()
                .id(modulo.getId())
                .nombre(modulo.getNombre())
                .horario(horarios)
                .build();

    }

    public static HorarioDTO toHorarioDTO(final HorarioModulo horarioModulo) {
        String horaInicio = Util.dateToFormato12horas(horarioModulo.getHoraInicio());
        String horaFin = Util.dateToFormato12horas(horarioModulo.getHoraFin());
        return HorarioDTO.builder()
                .id(horarioModulo.getId())
                .descripcion(Util.stringToCapitalize(horarioModulo.getDia()) + " " + horaInicio + " - " + horaFin)
                .build();
    }

    public static HorarioModulo createHorario(final CreateHorarioRequest request) {
        return HorarioModulo.builder()
                .dia(Util.validarDiaSemana(request.getDia()))
                .horaInicio(Util.numeroHoraToDateHora(request.getHoraInicio()))
                .horaFin(Util.numeroHoraToDateHora(request.getHoraFin()))
                .build();
    }

    public CreateHorarioResponse domainToDTO(HorarioModulo horarioModulo) {
        CreateHorarioResponse createHorarioResponse = new CreateHorarioResponse();
        createHorarioResponse.setId(horarioModulo.getId());
        createHorarioResponse.setNombre(horarioModulo.getNombre());
        createHorarioResponse.setHorario(horarioModulo.getHorario());
        return createHorarioResponse;
    }
    


}
