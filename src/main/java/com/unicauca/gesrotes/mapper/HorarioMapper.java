package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.common.Util;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.HorarioDTO;
import com.unicauca.gesrotes.dto.HorariosModulosDTO;
import com.unicauca.gesrotes.dto.ModuloDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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



    public static HorariosModulosDTO horarioModuloToDTO(List<HorarioModulo> horarioModulos) {
        List<ModuloDTO> modulos = new ArrayList<>();

        List<HorarioDTO> horarios = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");

        for(HorarioModulo hm : horarioModulos) {
            HorarioDTO horario = HorarioDTO.builder()
            .id(hm.getId())
            .descripcion(hm.getDia() + format.format(hm.getHoraInicio()) + "-" + format.format(hm.getHoraFin()))
            .build();
            horarios.add(horario);
        }


        for(HorarioModulo hm : horarioModulos) {
            ModuloDTO modulo = ModuloDTO.builder()
            .id(hm.getModulo().getId())
            .nombre(hm.getModulo().getNombre())
            .horarios(horarios)
            .build();
            modulos.add(modulo);
        }

        HorariosModulosDTO horarioModuloDTO =  HorariosModulosDTO.builder()
        .modulos(modulos)
        .build();
        System.out.println("Mapper: " + horarioModuloDTO);
        return horarioModuloDTO;
   }

}
