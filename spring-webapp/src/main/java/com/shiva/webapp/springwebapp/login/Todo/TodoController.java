package com.shiva.webapp.springwebapp.login.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"username", "loginForm"})
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String listAllTodos(ModelMap modelMap) {

        List<Todo> allTodos = todoService.findByUsername("shvia");

        System.out.println("##" + allTodos);

        modelMap.put("todos", allTodos);
        // modelMap.put("username", username);

        return "allTodo";
    }

    // @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    // public String listAll(){
    //
    // }


}
