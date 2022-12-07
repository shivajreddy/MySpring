package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseJpaCommandLiner implements CommandLineRunner {

    // private final CourseJpaRepository courseJpaRepository;
    //
    // public CourseJpaCommandLiner(CourseJpaRepository courseJpaRepository) {
    //     this.courseJpaRepository = courseJpaRepository;
    // }

    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    public CourseJpaCommandLiner(CourseSpringDataJpaRepository courseSpringDataJpaRepository) {
        this.courseSpringDataJpaRepository = courseSpringDataJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseSpringDataJpaRepository.save(new Course(1, "c++", "Bjarne Stroustrup"));
        courseSpringDataJpaRepository.save(new Course(2, "Java", "James Gosling"));
        courseSpringDataJpaRepository.save(new Course(3, "Python3.11", "Guido van Rossum"));


        // delete 1st row
        // courseSpringDataJpaRepository.deleteById(1);

        System.out.println(courseSpringDataJpaRepository.findById(2));
        System.out.println(courseSpringDataJpaRepository.findById(3));

        System.out.println("###" + courseSpringDataJpaRepository.findAll());

        System.out.println("##" + courseSpringDataJpaRepository.findByAuthor("James Gosling"));
        System.out.println("##" + courseSpringDataJpaRepository.findByAuthor("nope"));

        System.out.println("##" + courseSpringDataJpaRepository.findByName("java"));
        System.out.println("##" + courseSpringDataJpaRepository.findByName("c++"));

    }
}
