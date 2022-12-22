package com.shiva.employermanagementrestAPI.restapi.exception;

import java.time.LocalTime;

public class DetailError {

    private final String message;
    private final String description;
    private final LocalTime localTime;

    public DetailError(String message, String description, LocalTime localTime) {
        this.message = message;
        this.description = description;
        this.localTime = localTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}
