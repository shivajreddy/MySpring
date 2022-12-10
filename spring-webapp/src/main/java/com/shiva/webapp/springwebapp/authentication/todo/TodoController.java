package com.shiva.webapp.springwebapp.authentication.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/all-todos", method = RequestMethod.GET)
    public String allTodos(ModelMap modelMap) {
        System.out.println("@@ got get method");
        // bind all todos
        List<Todo> all_todos = todoService.getTodos();
        modelMap.put("todos", all_todos);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodoForm(ModelMap modelMap) {
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap modelMap) {
        System.out.println("## got post method");
        String username = (String) modelMap.get("name");
        // todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
        // todos.add(new Todo(++todosCount, username, description, LocalDate.now().plusYears(1), false));
        todoService.addTodo(username, description, false);
        return "redirect:all-todos";
    }


}
