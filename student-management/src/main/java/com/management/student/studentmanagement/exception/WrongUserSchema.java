package com.management.student.studentmanagement.exception;

public class WrongUserSchema extends RuntimeException {
    public WrongUserSchema(String message) {
        super(message);
    }
}
