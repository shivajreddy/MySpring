package com.shiva.ssch6e1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "demo 🔥";
    }

    @GetMapping("/demodemo")
    public String demoDemo() {
        return "demodemo 🔥";
    }

    @GetMapping("/demo/2")
    public String demo2() {
        return "demo 2️⃣ 🔥";
    }

    @PostMapping("/demo/2")
    public String postDemo2() {
        return "post demo 2️⃣ 🔥";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Admin page 😶";
    }

    @GetMapping("/admin/2")
    public String adminPage2() {
        return "Admin page - 2️⃣ 😶";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "Public page 🌈";
    }

}

