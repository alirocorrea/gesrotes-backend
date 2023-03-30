package com.unicauca.gesrotes.exception;

import com.unicauca.gesrotes.dto.response.ExceptionResponse;
import com.unicauca.gesrotes.mapper.ExceptionMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handleApplicationException(final ApplicationException ex, final WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.fromApplicationException(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<ExceptionResponse> handleDataException(final DataException ex, final WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.fromDataException(ex.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(final ConstraintViolationException ex, final WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.fromConstraintViolationException(ex.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
