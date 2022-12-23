package com.shiva.employermanagementrestAPI.restapi.exception;

import java.time.LocalTime;

public record DetailError(String message, String description, LocalTime localTime) {

}
