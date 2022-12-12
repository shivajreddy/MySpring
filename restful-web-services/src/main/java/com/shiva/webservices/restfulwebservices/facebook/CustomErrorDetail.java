package com.shiva.webservices.restfulwebservices.facebook;


import java.time.LocalTime;

public class CustomErrorDetail {

    // # fields
    private String message;
    private LocalTime timeStamp;
    private String description;

    // # constructor
    public CustomErrorDetail(String message, LocalTime timeStamp, String description) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    // # getters
    public String getMessage() {
        return message;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }
}

