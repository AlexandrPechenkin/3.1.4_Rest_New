package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest-admin")
public class RestAdminController {

    final
    UserService userService;

    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        List<User> list = userService.getAll();
        return list;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        User user = userService.getOne(id);
        return user;
    }

}
