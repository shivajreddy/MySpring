package com.shiva.webservices.restfulwebservices.twitter.database.schema;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserSchema {

    @NotBlank
    @Size(min = 5, max = 20, message = "userName must be in between 5 and 20")
    private String userName;

    @NotBlank
    @Size(min = 5, max = 20, message = "firstName must be in between 5 and 20")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 20, message = "lastName must be in between 5 and 20")
    private String lastName;

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

