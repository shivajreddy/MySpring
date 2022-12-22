/* Layer 3: Service
 *  Utility class for Data cleaning and calling the repository functions
 */

package com.management.student.studentmanagement.service;

import com.management.student.studentmanagement.entity.Student;
import com.management.student.studentmanagement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Optional<Student> getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}


@Service
class StudentServiceImp implements StudentService {

    // inject the StudentRepository dependency
    private final StudentRepository repository;

    @Autowired
    StudentServiceImp(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}