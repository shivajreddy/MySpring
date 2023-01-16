package com.shiva.ssiach3ex1.model;

import jakarta.persistence.*;

public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String authority;

}
