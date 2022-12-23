package com.shiva.studentsystem.restapi.service;

import com.shiva.studentsystem.restapi.module.Student;
import com.shiva.studentsystem.restapi.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return repository.findById(id);
    }

    public Student newStudent(Student student) {
        return repository.save(student);
    }

    public String deleteAllRows(){
        repository.deleteAll();
        return "delete all";
    }
}
