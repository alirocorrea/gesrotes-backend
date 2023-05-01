package com.unicauca.gesrotes.common;

import com.unicauca.gesrotes.exception.ApplicationException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public final class Util {

    private Util() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static String stringToUpperCase(final String str) {
        return Check.isNull(str) ? null : str.toUpperCase();
    }

    public static String getDateTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static LocalDate stringToLocalDate(final String fecha) {
        if (Check.isNotNull(fecha)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(fecha, formatter);
        }
        return null;
    }

    public static String localDateToString(final LocalDate fecha) {
        if (Check.isNotNull(fecha)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return fecha.format(formatter);
        }
        return null;
    }

    public static boolean esFechaMenorIgualActual(final LocalDate date) {
        return Check.isNotNull(date) && (date.compareTo(LocalDate.now()) <= 0);
    }

    public static String stringToCapitalize(final String str)
    {
        if (str != null && !str.isBlank()) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return null;
    }

    public static String dateToFormato12horas(final Date date) {
        if(date != null ) {
            SimpleDateFormat formato12Horas = new SimpleDateFormat("hh:mm a");
            return  formato12Horas.format(date);
        }
        return null;
    }

    public static String validarDiaSemana(final String dia) {
        try {
            Enums.Dias value = Enums.Dias.valueOf(dia.toUpperCase());
            return stringToCapitalize(value.name());
        } catch (IllegalArgumentException e) {
            throw new ApplicationException(Messages.DIA_SEMANA_INVALIDO);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static Date numeroHoraToDateHora(final Integer hora) {
        if(hora != null && hora >= 0 && hora < 24) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hora);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }
        throw new ApplicationException(Messages.NUMERO_HORA_INVALIDO);
    }
}
