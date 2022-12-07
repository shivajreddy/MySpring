package com.shiva.springboot.learnjpaandhibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "course")
public class Course {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    public Course() {
    }

    public Course(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id: " + id + " name: " + name + " author: " + author;
    }
}
