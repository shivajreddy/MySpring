package com.blog.blogrestapi.exception;

public class DuplicateTitleException extends RuntimeException {
    public DuplicateTitleException(String title) {
        super("There is a post already with title: " + title);
        // System.out.println("## DuplicateTitleException raised");
    }
}
