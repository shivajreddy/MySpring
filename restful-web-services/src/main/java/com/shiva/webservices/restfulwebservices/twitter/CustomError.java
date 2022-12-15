package com.shiva.webservices.restfulwebservices.twitter;

import java.time.LocalTime;

public class CustomError {

    // # Fields
    private String message;
    private String description;
    private LocalTime timeStamp;


    // # constructor
    public CustomError(String message, String description, LocalTime timeStamp) {
        this.message = message;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    // # Getters
    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }
}

