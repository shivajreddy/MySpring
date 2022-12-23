package com.shiva.studentsystem.restapi.exception;

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


@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {
    // # handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    protected ResponseEntity<DetailError> handleStudentNotFoundException(Exception exception, WebRequest request) {
        DetailError error = new DetailError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // # handle if wrong method args are passed i.e., wrong request body
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        System.out.println("## handling wrong method argument for StudentController");

        // create the custom message
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
