package com.shiva.webservices.restfulwebservices.twitter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    // Base exception handler for all exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleAllExceptions(Exception exception, WebRequest request) {
        CustomError customError = new CustomError(exception.getMessage(), request.getDescription(true), LocalTime.now());
        return new ResponseEntity<>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomError> handleUserNotFoundException(Exception exception, WebRequest request) {
        System.out.println("## reached the handleMethodArgumentNotValid");
        CustomError customError = new CustomError(exception.getMessage(), request.getDescription(true), LocalTime.now());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    // # Exception for wrong user info submitted in POST request
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        System.out.println("## reached the handleMethodArgumentNotValid");

        StringBuilder errorMessage = new StringBuilder("Total errors:" + exception.getErrorCount());
        int i = 0;
        for (FieldError error : exception.getFieldErrors()) {
            errorMessage.append(". Error-").append(++i).append(":").append(error.getDefaultMessage());
        }

        System.out.println("## reached 2 custom post error" + errorMessage.toString());

        CustomError customError = new CustomError(errorMessage.toString(), request.getDescription(true), LocalTime.now());

        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    // handle if there is no request body, but it must be present
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomError customError = new CustomError(ex.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }
}
