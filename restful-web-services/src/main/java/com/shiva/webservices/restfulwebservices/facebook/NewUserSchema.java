package com.shiva.webservices.restfulwebservices.facebook;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserSchema {

    @NotBlank(message = "username can't be blank")
    @Size(min = 4, max = 10, message = "username size should be b/w 4 and 10 chars")
    private String username;
    @NotBlank
    @Size(min = 4, max = 10, message = "firstName size should be b/w 4 and 10 chars")
    private String firstName;
    private String email;

    public NewUserSchema(String username, String firstName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

