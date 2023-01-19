package com.shiva.mysqldocker.controller;

import com.shiva.mysqldocker.models.User;
import com.shiva.mysqldocker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/new")
    public User makeANewUser(@RequestBody User userData) {
        System.out.println("input" + userData);
        return service.addNewUser(userData);
    }

}

/* terminal command

docker run --detach
 --env MYSQL_ROOT_PASSWORD=dummypassword
 --env MYSQL_USER=social-media-user
 --env MYSQL_PASSWORD=dummypassword
 --env MYSQL_DATABASE=social-media-database
 --name mysql
 --publish 3306:3306
 mysql:8-oracle

 docker run --detach
 --env MYSQL_ROOT_PASSWORD=pass@123
 --env MYSQL_USER=shiva
 --env MYSQL_PASSWORD=pass@123
 --env MYSQL_DATABASE=docker_db
 --name mysql
 --publish 3306:3306
 mysql:8-oracle

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

docker run --detach --env MYSQL_ROOT_PASSWORD=pass@123 --env MYSQL_USER=shiva --env MYSQL_PASSWORD=pass@123 --env MYSQL_DATABASE=docker_db --name mysql --publish 3306:3306 mysql:8-oracle

 */
