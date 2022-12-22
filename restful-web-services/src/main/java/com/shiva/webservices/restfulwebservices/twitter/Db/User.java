package com.shiva.webservices.restfulwebservices.twitter.Db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;

    @Column(name = "user_name")
    private String userName;

}
