package com.shiva.learnspringsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    private static List<Todo> TODO_LIST = List.of(new Todo("shiva", "java"), new Todo("reddy", "python"));

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/todos")
    public List<Todo> allTodos() {
        return TODO_LIST;
    }

    @PostMapping("/users/{username}/todos")
    public void createTodo(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("@@ Create {} for {}", todo, username);
    }

}

record Todo (String instructor, String courseName){};

