package com.shiva.webapp.springwebapp.login.Todo;

public class Todo {
    private final int id;
    private final String username;
    private String description;
    private boolean finished;

    public Todo(int id, String username, String description, boolean finished) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "## Todo [id= " + id +
                ", username" + username +
                ", description" + description +
                ", finished: " + finished +
                " ]";
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
