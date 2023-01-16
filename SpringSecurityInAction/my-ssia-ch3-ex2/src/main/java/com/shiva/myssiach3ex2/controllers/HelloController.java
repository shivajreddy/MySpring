package com.shiva.myssiach3ex2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        return "Howdy 👋🏽";
    }
}
