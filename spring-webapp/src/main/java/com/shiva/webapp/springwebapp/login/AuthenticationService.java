package com.shiva.webapp.springwebapp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUsername = username.equalsIgnoreCase("shiva");
        boolean isValidPassword = password.equalsIgnoreCase("pass");

        return isValidUsername && isValidPassword;

    }
}
