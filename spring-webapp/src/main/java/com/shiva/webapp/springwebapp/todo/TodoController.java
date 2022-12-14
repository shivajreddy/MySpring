package com.shiva.webapp.springwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;

import jakarta.validation.Valid;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all-todos")
    public String allTodos(ModelMap modelMap) {


        List<Todo> all_todos = todoService.getTodos();
        modelMap.put("todos", all_todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String addTodoForm(ModelMap modelMap) {

        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "default", LocalTime.now(), false);
        modelMap.put("todo", todo);

        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.isDone());

        return "redirect:all-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {

        System.out.println("@@ deleteTodo method");

        todoService.deleteTodo(id);
        return "redirect:all-todos";
    }

    @GetMapping("/update-todo")
    public String showTodoItem(@RequestParam int id, ModelMap modelMap) {

        Todo found_todo = todoService.getTodoById(id);

        modelMap.put("todo", found_todo);
        return "existingTodo";
    }

    @PostMapping("/update-todo")
    public String updateTodoItem(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        System.out.println("@@" + todo);
        todoService.updateTodo(todo);
        return "redirect:all-todos";
    }
}

