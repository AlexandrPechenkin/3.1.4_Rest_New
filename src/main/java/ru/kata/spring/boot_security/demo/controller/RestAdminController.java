package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//@RestController
//@RequestMapping("/rest-admin")
//public class RestAdminController {
//
//    final
//    UserService userService;
//
//    public RestAdminController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/users")
//    public List<User> allUsers() {
//        return userService.getAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public User getUser(@PathVariable long id) {
//        User user = userService.getOne(id);
//        return user;
//    }
//
//    @PostMapping("/users")
//    public User addUser(@RequestBody User user) {
//        userService.addUser(user);
//        return user;
//    }
//
//    @PutMapping("/users")
//    public User updateUser(@RequestBody User user) {
//        userService.addUser(user);
//        return user;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public String removeUser(@PathVariable long id) {
//        User user = userService.getOne(id);
//        if (user == null) {
//            throw new NoSuchElementException("Юзера нет");
//        }
//        userService.remove(user);
//        return "User with ID = " + id + " was deleted";
//    }

//}
