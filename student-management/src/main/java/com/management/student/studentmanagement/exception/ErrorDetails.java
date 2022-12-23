package com.management.student.studentmanagement.exception;

import java.time.LocalTime;

public class ErrorDetails {

    // fields
    private String message;
    private LocalTime timeStamp;
    private String description;

    // constructor


    public ErrorDetails(String message, LocalTime timeStamp, String description) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
