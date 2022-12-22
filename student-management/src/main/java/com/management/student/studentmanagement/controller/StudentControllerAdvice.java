package com.management.student.studentmanagement.controller;

import com.management.student.studentmanagement.exception.ErrorDetails;
import com.management.student.studentmanagement.exception.UserNotFound;
import com.management.student.studentmanagement.exception.WrongUserSchema;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {

    // Exception for every error, if no specific handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
        ErrorDetails error = new ErrorDetails(exception.getMessage(), LocalTime.now(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle if wrong request body at POST endpoint of "/students"
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        StringBuilder finalErrorMessage = new StringBuilder();

        int totalErrors = ex.getErrorCount();
        finalErrorMessage.append("Total errors:").append(totalErrors);
        for (int i = 0; i < totalErrors; i++) {
            var error = ex.getFieldErrors().get(i);
            finalErrorMessage.append(". Error- ").append(i + 1).append(": ").append(error.getDefaultMessage());
        }

        ErrorDetails error = new ErrorDetails(finalErrorMessage.toString(), LocalTime.now(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }

    // handle if extra arguments given in request body
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // # create custom error message, showing which extra fields are found
        ErrorDetails error = new ErrorDetails(ex.getMessage(), LocalTime.now(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WrongUserSchema.class)
    public ResponseEntity<ErrorDetails> handlerWrongUserSchema(Exception e, WebRequest req) {
        ErrorDetails error = new ErrorDetails(e.getMessage(), LocalTime.now(), req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    // handle if no user found with given id
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(Exception e, WebRequest req) {
        ErrorDetails error = new ErrorDetails(e.getMessage(), LocalTime.now(), req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
