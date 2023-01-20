package com.shiva.springsecuritydemistified.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello there 👋🏽";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "this is a private page 🤫";
    }

}
