package com.shiva.webapp.springwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    /* using a logger */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String welcomePage(@ModelAttribute LoginForm loginForm) {
        // System.out.println("Username: " + loginForm.getUsername());
        // System.out.println("Password: " + loginForm.getPassword());
        if (authenticationService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            return "resultPage";
        }
        return "welcome";
    }

}

