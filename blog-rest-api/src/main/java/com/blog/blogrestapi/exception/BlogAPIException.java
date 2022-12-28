package com.blog.blogrestapi.exception;

import org.springframework.http.HttpStatus;


/* BlogAPIException
 *
 * We throw this Exception:
 * when ever something fails in our business logic
 * if there is an error while validating parameters
 */
public class BlogAPIException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
