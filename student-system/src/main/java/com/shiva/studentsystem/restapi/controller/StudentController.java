package com.shiva.studentsystem.restapi.controller;

import com.shiva.studentsystem.restapi.exception.StudentNotFoundException;
import com.shiva.studentsystem.restapi.module.Student;
import com.shiva.studentsystem.restapi.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = service.getStudentById(id);
        if (student.isEmpty()) {
            System.out.println("@@ there is no students with id" + id);
            throw new StudentNotFoundException(id);
        }
        return student;
    }

    @PostMapping("/new")
    public Student createNewStudent(@RequestBody @Valid Student student) {
        return service.newStudent(student);
    }

    @DeleteMapping("/all")
    public String deleteAllRows() {
        return service.deleteAllRows();
    }

}
