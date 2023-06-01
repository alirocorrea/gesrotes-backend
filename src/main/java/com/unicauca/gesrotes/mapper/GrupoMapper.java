package com.unicauca.gesrotes.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Estudiante;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.response.GrupoResponse;

public final class GrupoMapper {

    private GrupoMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Grupo mapearGrupo() throws ParseException {
        Date hoy = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(hoy);
        int month=cal.get(Calendar.MONTH);
        String dateString;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter= new SimpleDateFormat(pattern);
        if(month<=6){
            dateString=cal.get(Calendar.YEAR)+"-06-30";
        }
        else{
            dateString=cal.get(Calendar.YEAR)+"-12-30";
        }

        return Grupo.builder()
        .vigencia(formatter.parse(dateString))
        .build();
    }

    public static GrupoResponse mapearResponse(Grupo save, int asociados) {
        return GrupoResponse.builder()
        .id(save.getId())
        .numero_grupo(asociados)//Contar grupos asociados a asigantura
        .asignaciones(new ArrayList<Estudiante>())//lista vacia
        .build();
    }

}
