package com.shiva.employermanagementrestAPI.restapi.controller;

import com.shiva.employermanagementrestAPI.restapi.exception.EmployeeNotFound;
import com.shiva.employermanagementrestAPI.restapi.model.Employee;
import com.shiva.employermanagementrestAPI.restapi.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/new")
    public ResponseEntity<Employee> newEmployee(@Valid @RequestBody Employee newEmployee, HttpServletRequest request) {
        Employee employee = service.saveEmployee(newEmployee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long id){
        Optional<Employee> foundEmployee = service.getEmployeeById(id);
        if (foundEmployee.isEmpty()) {
            throw new EmployeeNotFound(id);
        }
        service.removeEmployeeById(id);
        return new ResponseEntity<>(foundEmployee.get(), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public String deleteAllEmployee() {
        return service.removeAllEmployee();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> foundEmployee = service.getEmployeeById(id);
        if (foundEmployee.isEmpty()) {
            throw new EmployeeNotFound(id);
        }
        Employee employee = foundEmployee.get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        Employee updatedEmployee = service.saveEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

}

