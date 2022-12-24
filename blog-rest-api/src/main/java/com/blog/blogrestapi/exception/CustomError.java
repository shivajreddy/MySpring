package com.blog.blogrestapi.exception;

import java.time.LocalTime;

public class CustomError {
    private String message;
    private String description;
    private LocalTime timestamp;

    public CustomError(String message, String description, LocalTime timestamp) {
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
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

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }
}
