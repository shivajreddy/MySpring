package com.blog.blogrestapi.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("No post found with id:" + id);
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}

