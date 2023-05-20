package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;

public final class ExceptionMapper {

    private ExceptionMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static ExceptionResponse fromApplicationException(final String message, final HttpStatus status) {
        return ExceptionResponse.builder()
                .status(status.value())
                .error(Constants.APPLICATION_EXCEPTION)
                .message(message)
                .build();
    }

    public static ExceptionResponse fromDataException(final String message) {
        return ExceptionResponse.builder()
                .status(Constants.STATUS_BAD_REQUEST)
                .error(Constants.DATA_EXCEPTION)
                .message(message)
                .build();
    }

    public static ExceptionResponse fromConstraintViolationException(final String message) {
        return ExceptionResponse.builder()
                .status(Constants.STATUS_BAD_REQUEST)
                .error(Constants.CONSTRAINT_VIOLATION_EXCEPTION)
                .message(message)
                .build();
    }

    public static ExceptionResponse fromMethodArgumentNotValidException(final String message) {
        return ExceptionResponse.builder()
                .status(Constants.STATUS_BAD_REQUEST)
                .error(Constants.ARGUMENT_VIOLATION_EXCEPTION)
                .message(message)
                .build();
    }
}
