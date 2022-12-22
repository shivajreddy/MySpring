package com.shiva.employermanagementrestAPI.restapi.controller;

import com.shiva.employermanagementrestAPI.restapi.exception.EmployeeNotFound;
import com.shiva.employermanagementrestAPI.restapi.model.Employee;
import com.shiva.employermanagementrestAPI.restapi.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // inject service dependency
    private final EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> allEmployees = service.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id) throws Exception {
        System.out.println("@@ id=" + id);
        Optional<Employee> employee = service.getEmployeeById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFound(id);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}

