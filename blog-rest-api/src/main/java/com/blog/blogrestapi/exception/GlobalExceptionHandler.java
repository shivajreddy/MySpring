package com.blog.blogrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                       WebRequest request) {
        CustomError error = new CustomError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // handle BlogApiException
    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<CustomError> handleBlogAPIException(BlogAPIException exception,
                                                              WebRequest request) {
        CustomError error = new CustomError(exception.getMessage(),
                request.getDescription(false),
                LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // handle duplicate title exception
    @ExceptionHandler(DuplicateTitleException.class)
    public ResponseEntity<CustomError> handleDuplicateTitleException(Exception exception, WebRequest request) {
        CustomError error = new CustomError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
