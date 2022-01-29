package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;



@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String users(Model model) {

        model.addAttribute("users", userService.getAll());

        return "users";
    }

    @GetMapping("/admin/users/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/admin/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/admin/users")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/users";

    }

    @GetMapping("/admin/users/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/admin/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.remove(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }


}