package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseCommandLineRunner(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // command line runner method
    @Override
    public void run(String... args) throws Exception {
        // courseRepository.addRow(new Course(1, "c++", "Bjarne Stroustrup"));
        // courseRepository.addRow(new Course(2, "Java", "James Gosling"));
        // courseRepository.addRow(new Course(3, "Python", "Guido van Rossum"));
        //
        // // delete 1st row
        // courseRepository.deleteRowWithId(1);
        //
        // System.out.println(courseRepository.selectWithId(2));
        // System.out.println(courseRepository.selectWithId(3));
    }

}
