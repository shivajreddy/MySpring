package com.shiva.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

class Course {
    private int id;
    private String courseName;
    private String instructor;


    public Course(int id, String courseName, String instructor) {
        super();
        this.id = id;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "Course : " + courseName + "," + "Name: " + instructor;
    }
}


@RestController(value = "/courses")
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getCourses() {

        return Arrays.asList(new Course(1, "Learn AWS", "Ranga"), new Course(2, "Learn Dev", "Ranga"));

    }

}
