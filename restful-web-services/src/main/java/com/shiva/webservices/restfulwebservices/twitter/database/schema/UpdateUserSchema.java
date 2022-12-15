package com.shiva.webservices.restfulwebservices.twitter.database.schema;

import jakarta.annotation.Nullable;

public class UpdateUserSchema {

    @Nullable
    private String userName;
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

