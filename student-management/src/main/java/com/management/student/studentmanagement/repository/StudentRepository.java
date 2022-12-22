/* Layer 2: Repository
 *
 * All the SQL queries happen here
 */


package com.management.student.studentmanagement.repository;

import com.management.student.studentmanagement.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
