package com.blog2.blogrestapi2.exception;

import java.time.LocalTime;

public class CustomError {
    private String message;
    private String description;
    private LocalTime timeStamp;

    public CustomError(String message, String description, LocalTime timeStamp) {
        this.message = message;
        this.description = description;
        this.timeStamp = timeStamp;
    }

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
