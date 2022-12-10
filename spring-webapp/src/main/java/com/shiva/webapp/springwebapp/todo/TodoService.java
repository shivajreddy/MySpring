package com.shiva.webapp.springwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public static List<Todo> todos = new ArrayList<>();
    public static int todosCount;


    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS", LocalTime.now(), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps", LocalTime.now(), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development", LocalTime.now(), false));
    }


    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(String username, String description, boolean done) {
        todos.add(new Todo(++todosCount, username, description, LocalTime.now(), false));
    }

    public void deleteTodo(int deleteId) {

        /** using predicate & lambda functions
         name_of_bean -> bean.getId() == id
         */
        // Predicate<? super Todo> predicate = todo -> todo.getId() == deleteId;
        // todos.removeIf(predicate);

        for (int idx = 0; idx < todos.size(); ++idx) {
            if (todos.get(idx).getId() == deleteId) {
                todos.remove(idx);
                break;
            }
        }
    }

    public Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo newTodo) {
        for (Todo todo : todos) {
            if (todo.getId() == newTodo.getId()) {
                todo.setUsername(newTodo.getUsername());
                todo.setDescription(newTodo.getDescription());
                todo.setTargetTime(LocalTime.now());
                todo.setDone(newTodo.isDone());
                break;
            }
        }
    }

}
