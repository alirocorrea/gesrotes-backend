package com.unicauca.gesrotes.common;

public final class Constants {

    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    //SWAGGER
    public static final String SWAGGER_TITLE = "API GESROTES Backend";
    public static final String SWAGGER_DESCRIPTION = "Servicios REST para el proyecto de GESROTES de la Universidad del Cauca, CO";
    public static final String SWAGGER_VERSION = "v0.0.1";
    public static final String SWAGGER_SERVER_URL = "/";
    public static final String SWAGGER_SERVER_DESCRIPTION = "GESROTES SERVER";

    //EXCEPCIONES
    public static final Integer STATUS_BAD_REQUEST = 400;
    public static final String APPLICATION_EXCEPTION = "Application Exception";
    public static final String DATA_EXCEPTION = "Data Exception";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "Constraint Violation Exception";

    //GENERAL
    public static final String UTILITY_CLASS = "Utility class";
}
