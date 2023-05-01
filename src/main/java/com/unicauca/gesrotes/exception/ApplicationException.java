package com.unicauca.gesrotes.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApplicationException extends RuntimeException {

    private final HttpStatus status;

    public ApplicationException(final String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ApplicationException(final String message, final HttpStatus status) {
        super(message);
        this.status = status;
    }
}
