package com.shiva.webservices.restfulwebservices.facebook;


public class User {
    private int id;
    private String username;
    private String firstName;
    private String email;

    public User(int id, String username, String firstName, String email) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
