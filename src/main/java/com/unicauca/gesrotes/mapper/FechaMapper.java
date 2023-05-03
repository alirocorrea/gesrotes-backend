package com.unicauca.gesrotes.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.FechaResponse;

public final class FechaMapper {
    
    private FechaMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static FechaResponse mapearResponse(Date fecha) {
        Locale locale = new Locale("es", "ES");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return FechaResponse.builder()
        .mes(cal.getDisplayName(Calendar.MONTH, Calendar.LONG,locale))
        .dia(cal.get(Calendar.DAY_OF_MONTH))
        .anyo(cal.get(Calendar.YEAR))
        .build();
    }

}