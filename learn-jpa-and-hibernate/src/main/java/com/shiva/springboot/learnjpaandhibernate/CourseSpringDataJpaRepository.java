package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {


    // custom methods we can add
    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);

}


