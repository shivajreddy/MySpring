package com.blog2.blogrestapi2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    // handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest request
    ) {
        CustomError error = new CustomError(
                exception.getMessage(),
                request.getDescription(false),
                LocalTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Global Exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleGlobalException(
            Exception exception,
            WebRequest request
    ) {
        CustomError error = new CustomError(
                exception.getMessage(),
                request.getDescription(false),
                LocalTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
