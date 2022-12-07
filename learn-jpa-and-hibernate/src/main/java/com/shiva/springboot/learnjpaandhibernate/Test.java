package com.shiva.springboot.learnjpaandhibernate;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {

        Class<?> clazz = Course.class;

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f + " : " + f.getName());
        }
    }
}
