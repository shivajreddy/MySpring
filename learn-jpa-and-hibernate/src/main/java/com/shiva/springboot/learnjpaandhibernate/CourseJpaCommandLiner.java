package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLiner implements CommandLineRunner {

    private final CourseJpaRepository courseJpaRepository;

    public CourseJpaCommandLiner(CourseJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "c++", "Bjarne Stroustrup"));
        courseJpaRepository.insert(new Course(2, "Java", "James Gosling"));
        courseJpaRepository.insert(new Course(3, "Python3.11", "Guido van Rossum"));


        // delete 1st row
        courseJpaRepository.deleteById(1);

        System.out.println(courseJpaRepository.findById(2));
        System.out.println(courseJpaRepository.findById(3));

    }
}
