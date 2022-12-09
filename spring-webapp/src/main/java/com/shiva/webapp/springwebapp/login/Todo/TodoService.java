package com.shiva.webapp.springwebapp.login.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "shvia", "descr1", false));
        todos.add(new Todo(1, "shvia", "descr1", false));
        todos.add(new Todo(1, "shvia", "descr1", false));
    }


    public List<Todo> findByUsername(String username) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todos) {
            if (Objects.equals(todo.getUsername(), username)) {
                result.add(todo);
            }
        }
        return result;
    }


}
