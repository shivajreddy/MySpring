package com.shiva.webapp.springwebapp.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {

        List<Ball> bag = new ArrayList<>();

        bag.add(new Ball(1, "red"));
        bag.add(new Ball(2, "blue"));
        bag.add(new Ball(3, "green"));

        System.out.println("## bag = " + bag);

        for (Ball ball : bag) {
            System.out.println("checking" + ball);
            if (Objects.equals(ball.getColor(), "blue")) {
                bag.remove(bag.indexOf(ball));
                break;
            }
        }

        System.out.println("## bag = " + bag);

    }
}


class Ball {
    private int id;
    private String color;

    public Ball(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball: [" + id + ", " + color + "]";
    }
}

