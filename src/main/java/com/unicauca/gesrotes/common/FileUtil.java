package com.unicauca.gesrotes.common;

import java.util.Base64;

public final class FileUtil {

    private FileUtil() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static byte[] base64ToByteArray(final  String fileBase64) {
        return Base64.getMimeDecoder().decode(fileBase64);
    }

    public static String byteArrayToBase64(final byte[] file) {
        return Base64.getMimeEncoder().encodeToString(file);
    }

    public static boolean emptyByteArray(final byte[] array) {
        return array == null || array.length < 1;
    }

    public static String stringToBase64(final String str) {
        return str == null ? null : Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String base64ToString(final String base64) {
        if (base64 != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(base64);
            return new String(decodedBytes);
        }
        return null;
    }
}