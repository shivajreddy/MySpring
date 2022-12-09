package com.shiva.webapp.springwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@SessionAttributes({"username", "loginForm"})
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
    public String welcomePage(HttpServletRequest request, Model model) {
        // public String welcomePage(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername(request.getParameter("username"));
        loginForm.setPassword(request.getParameter("password"));

        System.out.println("##" + "loginForm: " + loginForm);

        if (authenticationService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            model.addAttribute("username", loginForm.getUsername());
            model.addAttribute("loginForm", loginForm);
            return "resultPage";
        }
        return "welcome";
    }

}

