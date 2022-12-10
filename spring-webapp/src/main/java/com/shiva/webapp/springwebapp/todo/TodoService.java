package com.shiva.webapp.springwebapp.authentication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public static List<Todo> todos = new ArrayList<>();
    public static int todosCount;


    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }


    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String username, String description,boolean done) {
        todos.add(new Todo(++todosCount, username, description, LocalDate.now().plusYears(1), false));
    }

}
