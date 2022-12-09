package com.shiva.webapp.springwebapp.login;


import java.util.Objects;

public class AuthenticateService {

    private final String username;
    private final String password;

    public AuthenticateService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
        return Objects.equals(username, "shiva") && Objects.equals(password, "pass");
    }

}
