package com.shiva.webservices.restfulwebservices.twitter;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
