package com.shiva.webapp.springwebapp.login;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {

    public static List<Todo> allTodos = new ArrayList<>();

    static {
        allTodos.add(new Todo(1, "shiva", "descr1", true));
        allTodos.add(new Todo(2, "shiva", "descr1", false));
        allTodos.add(new Todo(3, "shiva", "descr1", true));
    }

    public List<Todo> getTodosByUser(String name) {

        List<Todo> resultTodos = new ArrayList<>();

        for (Todo todo : allTodos) {
            if (Objects.equals(todo.getName(), name)) {
                resultTodos.add(todo);
            }
        }
        return resultTodos;
    }

}

