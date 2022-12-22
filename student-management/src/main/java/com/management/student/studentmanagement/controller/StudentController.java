/* Controller for /student end-point
 *
 *Entry point for /student end point
 * calls the service layer for getting from the DB
 */
package com.management.student.studentmanagement.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.management.student.studentmanagement.entity.Student;
import com.management.student.studentmanagement.exception.UserNotFound;
import com.management.student.studentmanagement.exception.WrongUserSchema;
import com.management.student.studentmanagement.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> listStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/students/{user_id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int user_id) {
        Optional<Student> student = studentService.getStudentById((long) user_id);
        if (student.isEmpty()) {
            throw new UserNotFound((long) user_id, "no user found with");
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/students")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity<Student> createNewStudent(@Valid @RequestBody Student newStudent, HttpServletRequest request) {
        // throw error if extra parameters are given
        // Map<String, String[]> map = request.getParameterMap();
        // System.out.println("@@ this is the map" + map);
        Student student = studentService.saveStudent(newStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}

