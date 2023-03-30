package com.unicauca.gesrotes.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
