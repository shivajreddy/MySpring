package com.shiva.studentsystem.restapi.exception;

import java.time.LocalTime;

public class DetailError {
    private String message;
    private String description;
    private LocalTime timeStamp;

    public DetailError(String message, String description, LocalTime timeStamp) {
        this.message = message;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    // TODO: not sure if i can get rid of setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
