package com.shiva.webapp.springwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addTodoForm() {
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@RequestParam String description, @RequestParam String username, ModelMap modelMap) {

        System.out.println("## got post method");

        // String username = (String) modelMap.get("name");
        todoService.addTodo(username, description, false);
        return "redirect:all-todos";
    }


}
