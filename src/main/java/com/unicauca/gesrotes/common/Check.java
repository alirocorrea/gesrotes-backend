package com.unicauca.gesrotes.common;

import java.util.List;

public final class Check {

    private Check() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static boolean isNull(final Object object) {
        return object == null;
    }

    public static boolean isNotNull(final Object object) {
        return !isNull(object);
    }

    public static boolean emptyString(final String cadena) {
        return cadena == null || cadena.trim().isEmpty();
    }

    public static <T> boolean emptyList(final List<T> lista) {
        return null == lista || lista.isEmpty();
    }

    public static boolean emptyArray(final Object... params) {
        return null == params || params.length < 1;
    }

    public static boolean isTrue(final Boolean valor) {
        return valor != null && valor;
    }

    public static boolean isFalse(final Boolean valor) {
        return valor != null && !valor;
    }

    public static boolean isNullOrFalse(final Boolean valor) {
        return valor == null || !valor;
    }
}
