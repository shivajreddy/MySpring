package com.shiva.webapp.springwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all-todos")
    public String allTodos(ModelMap modelMap) {

        System.out.println("@@ works");

        List<Todo> all_todos = todoService.getTodos();
        modelMap.put("todos", all_todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String addTodoForm(ModelMap modelMap) {

        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);

        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(ModelMap modelMap, Todo todo) {

        todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.isDone());

        return "redirect:all-todos";
    }


}
