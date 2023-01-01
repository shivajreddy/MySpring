package com.blog.blogrestapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;
import java.util.HashMap;

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

    // handle wrong argument passed
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleGlobalError(Exception exception, WebRequest request) {
        CustomError error = new CustomError(exception.getMessage(), request.getDescription(false), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
