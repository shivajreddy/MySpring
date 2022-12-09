package com.shiva.webapp.springwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({"username", "password"})
public class LoginController {

    TodoService todoService;

    public LoginController(TodoService todoService) {
        this.todoService = todoService;
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPostMethod(HttpServletRequest request, Model model) {

        // get form-data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Add data to session
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        AuthenticateService authenticateService = new AuthenticateService(username, password);

        // success
        if (authenticateService.authenticate()) {
            List<Todo> userTodos = todoService.getTodosByUser(username);
            model.addAttribute("todos", userTodos);
            return "resultPage";
            // return "allTodo";
        }

        // failed
        return "wrongUser";

    }

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public String allTodo() {
        return "allTodo";
    }
}

