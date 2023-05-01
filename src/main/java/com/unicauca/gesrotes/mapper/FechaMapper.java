package com.unicauca.gesrotes.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.FechaResponse;

public final class FechaMapper {
    
    private FechaMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static FechaResponse mapearResponse(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return FechaResponse.builder()
        .mes(new SimpleDateFormat("MMM").format(cal.get(Calendar.MONTH)))
        .dia(cal.get(Calendar.DAY_OF_MONTH))
        .anyo(cal.get(Calendar.YEAR))
        .build();
    }

}