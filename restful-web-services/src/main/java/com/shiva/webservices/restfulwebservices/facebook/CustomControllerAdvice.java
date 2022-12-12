package com.shiva.webservices.restfulwebservices.facebook;


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
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorDetail> handleAllExceptions(Exception ex, WebRequest req) {

        CustomErrorDetail errorDetail = new CustomErrorDetail(ex.getMessage(), LocalTime.now(), req.getDescription(false));

        return new ResponseEntity<CustomErrorDetail>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<CustomErrorDetail> handleNoUserFoundExceptions(Exception ex, WebRequest req) {

        CustomErrorDetail errorDetail = new CustomErrorDetail(ex.getMessage(), LocalTime.now(), req.getDescription(false));

        return new ResponseEntity<CustomErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
    }


    /**
     * Handle wrong user schema for creating new user
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        // Building custom error message
        StringBuilder errorMessage = new StringBuilder("Total errors:" + ex.getErrorCount());
        int i = 0;
        for (FieldError error : ex.getFieldErrors()) {
            errorMessage.append(". Error-").append(++i).append(":").append(error.getDefaultMessage());
        }

        CustomErrorDetail errorDetail = new CustomErrorDetail(errorMessage.toString(), LocalTime.now(), request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}

