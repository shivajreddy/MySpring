package com.blog2.blogrestapi2.exception;

import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public BlogApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
