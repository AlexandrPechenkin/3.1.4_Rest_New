package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleService roleService;
    private final UserService userService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/users")
    public String allUsers(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByEmail(principal.getName()));
        model.addAttribute("users", userService.getAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("role", roleService.getAll());
        return "admin-page";
    }

    @PostMapping(value = "/newuser")
    public String create(@ModelAttribute("user") User user, @RequestParam(name = "roleId") long[] roleId) {

        user.setRoles(roleService.getSetOfRoles(roleId));
        userService.addUser(user);
        return "redirect:users";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute("user") User user) {
                userService.remove(user);
        return "redirect:users";
    }

    @GetMapping(value = "/edit")
    @ResponseBody
    public User edit(Long id) {
        return userService.getOne(id);
    }
}