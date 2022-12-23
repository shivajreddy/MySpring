package com.shiva.employermanagementrestAPI.restapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DetailError> handleAllExceptions(Exception exception, WebRequest request) {
        System.out.println("## custom exception handler for all exceptions");
        DetailError error = new DetailError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<DetailError> handleEmployeeNotFoundException(Exception exception, WebRequest request) {
        System.out.println("## custom exception handler for EmployeeNotFoundException");
        DetailError error = new DetailError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        System.out.println("@@ MethodArgumentNotValidException handler");
        System.out.println("@@" + request.getDescription(true));
        // System.out.println("@@" + request.);


        // make a clean message
        StringBuilder finalErrorMessage = new StringBuilder();
        int totalErrors = ex.getErrorCount();
        finalErrorMessage.append("Total errors:").append(totalErrors);
        for (int i = 0; i < totalErrors; i++) {
            FieldError error = ex.getFieldErrors().get(i);
            finalErrorMessage.append(". Error- ").append(i + 1).append(": ").append(error.getDefaultMessage());
        }
        DetailError error = new DetailError(finalErrorMessage.toString(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

}
