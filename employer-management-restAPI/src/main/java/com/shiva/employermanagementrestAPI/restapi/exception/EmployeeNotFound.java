package com.shiva.employermanagementrestAPI.restapi.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(Long id) {
        super("No employee with id: " + id);
    }

}
