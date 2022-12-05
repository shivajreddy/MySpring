package com.shiva.springboot.learnspringboot;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

@RestController
public class CourseController {
    @RequestMapping("/")
    public String root() {
        return "SpringBoot3.0";
    }

    @RequestMapping("/courses")
    public List<Course> getCourses() {
        return Arrays.asList(new Course(1, "Learn AWS", "Ranga"), new Course(2, "Learn Dev", "Ranga"));
    }


    // 1. Set the response MIME type
    @RequestMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> imageEndpoint() throws IOException {

        var path = new ClassPathResource("static/images/shiva_memoji.jpg");
        // 2.Create ByteArrayResource for the image at given path
        byte[] bytes = StreamUtils.copyToByteArray(path.getInputStream());
        // final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(path)));

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

}
