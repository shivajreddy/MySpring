package com.shiva.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST =
            List.of(new Todo("in28minutes", "Learn AWS"),
                    new Todo("in28minutes", "Get AWS Certified"));

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username
            , @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

}

record Todo(String username, String description) {
}
