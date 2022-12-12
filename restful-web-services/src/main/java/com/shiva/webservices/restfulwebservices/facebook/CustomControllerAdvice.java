package com.shiva.webservices.restfulwebservices.facebook;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}

