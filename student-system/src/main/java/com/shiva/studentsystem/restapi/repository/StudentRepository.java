package com.shiva.studentsystem.restapi.repository;

import com.shiva.studentsystem.restapi.module.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
