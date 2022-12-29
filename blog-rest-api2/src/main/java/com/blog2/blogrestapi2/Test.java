package com.blog2.blogrestapi2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {

    @GetMapping("/test")
    public String test() {
        return "test pass ✅";
    }
}
