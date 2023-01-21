package com.shiva.ssch5e1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "hi demo 👋🏽";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "ADMIN page ⛑️";
    }
}
