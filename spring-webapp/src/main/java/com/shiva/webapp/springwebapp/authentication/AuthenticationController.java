package com.shiva.webapp.springwebapp.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {

    // inject AuthenticationService dependency
    AuthenticationService authenticateService;

    public AuthenticationController(AuthenticationService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAttempt(HttpServletRequest request) {

        String givenUsername = request.getParameter("username");
        String givenPassword = request.getParameter("password");

        // success
        if (authenticateService.verifyCredentials(givenUsername, givenPassword)) {
            return "sayHello";
        }

        // fail
        return "wrongUser";
    }

}
