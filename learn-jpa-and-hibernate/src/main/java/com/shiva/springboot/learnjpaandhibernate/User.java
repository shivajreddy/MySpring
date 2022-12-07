package com.shiva.springboot.learnjpaandhibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_table")
public class User {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "subscribed")
    private boolean subscribed;

    // empty constructor for RowMapper
    public User() {
    }

    // constructor for creating user object
    public User(int id, String name, int age, boolean subscribed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subscribed = subscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        return "User [" +
                " id: " + id +
                " name: " + name +
                " age: " + age +
                " subscribed: " + subscribed +
                " ]";
    }

}
