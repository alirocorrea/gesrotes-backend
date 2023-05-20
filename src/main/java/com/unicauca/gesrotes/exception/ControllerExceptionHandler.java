package com.unicauca.gesrotes.exception;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.common.Messages;
import com.unicauca.gesrotes.dto.response.ExceptionResponse;
import com.unicauca.gesrotes.mapper.ExceptionMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handleApplicationException(final ApplicationException ex, final WebRequest webRequest) {
        ExceptionResponse response = ExceptionMapper.fromApplicationException(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(response, ex.getStatus());
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> "'" + e.getField() + "'" + Constants.ESPACIO_EN_BLANCO + e.getDefaultMessage())
                .collect(Collectors.toList());
        String message = Messages.ERROR_VALIDACION_EN + String.join(" , ", errors);
        ExceptionResponse response = ExceptionMapper.fromMethodArgumentNotValidException(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
