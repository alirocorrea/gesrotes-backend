package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.common.Util;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.HorarioDTO;
import com.unicauca.gesrotes.dto.HorarioModuloDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class HorarioMapper {

    //private HorarioMapper() {
      //  throw new IllegalStateException(Constants.UTILITY_CLASS);
   // }

    public static CreateHorarioResponse toCreateHorarioResponse (final Modulo modulo, final List<HorarioDTO> horarios) {
        return CreateHorarioResponse.builder()
                .id(modulo.getId())
                .nombre(modulo.getNombre())
                .horario(horarios)
                .build();

    }

    public static HorarioDTO toHorarioDTO(final HorarioModulo horarioModulo) {
       // String horaInicio = Util.dateToFormato12horas(horarioModulo.getHoraInicio());
        //String horaFin = Util.dateToFormato12horas(horarioModulo.getHoraFin());
        return HorarioDTO.builder()
                .id(horarioModulo.getId())
                //.descripcion(Util.stringToCapitalize(horarioModulo.getDia()) + " " + horaInicio + " - " + horaFin)
                .dia(horarioModulo.getDia())
                .horaInicio(horarioModulo.getHoraInicio())
                .horaFin(horarioModulo.getHoraFin())
                .build();
    }

    public static HorarioModulo createHorario(final CreateHorarioRequest request) {
        return HorarioModulo.builder()
                .dia(Util.validarDiaSemana(request.getDia()))
                .horaInicio(Util.numeroHoraToDateHora(request.getHoraInicio()))
                .horaFin(Util.numeroHoraToDateHora(request.getHoraFin()))
                .build();
    }

    public HorarioDTO domainToDTO(HorarioModulo horarioModulo) {
         HorarioDTO horarioDTO =  HorarioDTO.builder()
        .id(horarioModulo.getId())
        .dia(horarioModulo.getDia())
        .horaInicio(horarioModulo.getHoraInicio())
        .horaFin(horarioModulo.getHoraFin())
        .build();
        return horarioDTO;
    }
    

    public HorarioModuloDTO horarioModuloToDTO(HorarioModulo horarioModulo) {
        HorarioModuloDTO horarioModuloDTO =  HorarioModuloDTO.builder()
        .nombreModulo(horarioModulo.getModulo().getNombre())
       .codigoAsignatura(horarioModulo.getModulo().getDocente().getAsignaturas().get(0).getCodigo())
       .descripcionAsignatura(horarioModulo.getModulo().getDocente().getAsignaturas().get(0).getDescripcion())
       .dia(horarioModulo.getDia())
       .horaInicio(horarioModulo.getHoraInicio())
       .horaFin(horarioModulo.getHoraFin())
       .nombreEscenario(horarioModulo.getEscenario().getNombre())
       .descripcionServicio(horarioModulo.getServicio().getDescripcion())
       .build();
       return horarioModuloDTO;
   }


}
