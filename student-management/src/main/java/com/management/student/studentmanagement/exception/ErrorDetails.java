package com.management.student.studentmanagement.exception;

import java.time.LocalTime;

public class ErrorDetails {

    // fields
    private final String message;
    private final LocalTime timeStamp;
    private final String description;

    // constructor


    public ErrorDetails(String message, LocalTime timeStamp, String description) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.description = description;
    }

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
