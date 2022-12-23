package com.shiva.studentsystem.restapi.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("No Student found with id: " + id);
    }
}
