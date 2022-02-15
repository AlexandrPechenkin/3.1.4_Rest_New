package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminRestController {


    private final RoleService roleService;
    private final UserService userService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostMapping(value = "/users")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.getAll());
    }





    @PostMapping(value = "/add")
    public ResponseEntity<Void> create(@RequestParam String firstName, String password, String lastName,
                                       String email, byte age, @RequestParam(name = "roleId") long[] roleId) {

        User user = new User(firstName, lastName, age, email, password);
        roleService.getSetOfRoles(user, roleId);
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping("/edit")
    public ResponseEntity<Void> edit(@RequestParam long id, String firstName, String password, String lastName,
                                     String email, byte age, @RequestParam(name = "roleId") long[] roleId) {
        User user = new User(id, firstName, lastName, age, email, password);
        roleService.getSetOfRoles(user, roleId);
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam long id) {
        userService.remove(userService.getOne(id));
        return new ResponseEntity<>(HttpStatus.OK);

    }
}



