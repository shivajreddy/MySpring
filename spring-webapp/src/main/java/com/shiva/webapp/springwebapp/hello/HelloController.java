package com.shiva.webapp.springwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class HelloController {

    @RequestMapping("/hi")
    public String sayHello() {
        return "sayHello";
    }

}
