package com.shiva.employermanagementrestAPI.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DetailError> handleAllExceptions(Exception exception, WebRequest request) {
        DetailError error = new DetailError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<DetailError> handleEmployeeNotFoundException(Exception exception, WebRequest request) {
        DetailError error = new DetailError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
