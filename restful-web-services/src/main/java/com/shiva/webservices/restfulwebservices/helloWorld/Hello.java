package com.shiva.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

    @GetMapping("/hello-bean")
    public HelloBean helloWorldBean() {
        return new HelloBean("hello world bean");
    }

    @GetMapping("/hello/{id}/path/{some_name}")
    public HelloBean helloPath(@PathVariable String some_name, @PathVariable int id) {
        return new HelloBean(some_name + " : " + id);
    }
}
