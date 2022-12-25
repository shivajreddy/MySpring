package com.blog.blogrestapi.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("No post found with id:" + id);
        // System.out.println("## PostNotFoundException raised");
    }
}

