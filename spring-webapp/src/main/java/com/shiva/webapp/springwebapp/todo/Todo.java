package com.shiva.webapp.springwebapp.todo;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Todo {
    private int id;
    @NotBlank(message = "must not be blank")
    private String username;
    @Size(min = 10, message = "Min. 10 chars")
    private String description;
    private LocalTime targetTime;
    private boolean done;

    public Todo(int id, String username, String description, LocalTime targetTime, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetTime = targetTime;
        this.done = done;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(LocalTime targetTime) {
        this.targetTime = targetTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetTime + ", done=" + done + "]";
    }

}
