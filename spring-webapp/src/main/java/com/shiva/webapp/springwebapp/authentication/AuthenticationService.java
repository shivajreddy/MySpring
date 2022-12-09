package com.shiva.webapp.springwebapp.authentication;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {


    private final String username = "shiva";
    private final String password = "pass";

    protected boolean verifyCredentials(String givenUsername, String givenPassword) {

        return Objects.equals(givenUsername, username) && Objects.equals(givenPassword, password);

    }

}
