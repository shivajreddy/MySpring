package com.shiva.mysqldocker.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDao {
    private final String name;
    private final String password;
}
