package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = AdminRestController.ADMIN_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {

    public static final String ADMIN_URL = "/admin";

    private final RoleService roleService;
    private final UserService userService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    @PostMapping(value = "/users")
    public List<User> allUsers() {
        return userService.getAll();
    }



//    @PostMapping(value = "/add")
//    public String create(@ModelAttribute("user") User user, @RequestParam(name = "roleId") long[] roleId) {
//
//        user.setRoles(roleService.getSetOfRoles(roleId));
//        userService.addUser(user);
//        return "redirect:users";
//    }
//
//    @PostMapping(value = "/delete")
//    public String delete(@ModelAttribute("user") User user) {
//        userService.remove(user);
//        return "redirect:users";
//    }
//
//    @GetMapping(value = "/edit")
//    @ResponseBody
//    public User edit(Long id) {
//        return userService.getOne(id);
//    }
}


//@RestController
//@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
//public class AdminRestController {
//
//    public static final String ADMIN_URL = "/admin";
//
//    private final UserService userService;
//
//    private final RoleService roleService;
//
//    public AdminRestController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//
//    @PostMapping(value = "/users")
//    public List<User> allUsers() {
//        return userService.getAll();
//    }
//
//    @PostMapping(value = "/add")
//    public void create(@RequestParam String firstName, String password, String lastName, String email, byte age, @RequestParam(name = "roleId") long[] roleId) {
//        User user = new User(firstName, lastName, age, email, password);
//        roleService.relation(user, roleId);
//        userService.addUser(user);
//    }
//
//    @PostMapping(value = "/edit")
//    public void create(@RequestParam Long id, String firstName, String password, String lastName, String email, byte age, @RequestParam(name = "roleId") long[] roleId) {
//        User user = new User(id, firstName, lastName, age, email, password);
//        roleService.relation(user, roleId);
//        userService.addUser(user);
//    }
//
//    @PostMapping(value = "/delete")
//    public void delete(@RequestParam Long id) {
//        userService.remove(userService.getOne(id));
//    }
//
//
//    @PostMapping(value = "/roles")
//    public List<Role> getRoles() {
//        return roleService.getAll();
//    }
//}
//
//


//@RestController
//@RequestMapping("/admin")
//public class AdminRestController {
//
//    private final UserService userService;
//    private final RoleService roleService;
//
//    public AdminRestController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }

//////////////////////мое старое
//    @GetMapping(value = "/login")
//    public String loginPage() {
//        return "login";
//    }


//    @GetMapping(value = "/users")
//    public String allUsers(Principal principal, Model model) {
//        model.addAttribute("user", userService.getUserByEmail(principal.getName()));
//        model.addAttribute("users", userService.getAll());
//        model.addAttribute("newUser", new User());
//        model.addAttribute("role", roleService.getAll());
//        return "admin-page";
//    }
//
//    @GetMapping(value = "/users")
//    public List<User> allUsers() {
//        return userService.getAll();
//    }


//    @PostMapping(value = "/add")
//    public String create(@ModelAttribute("user") User user, @RequestParam(name = "roleId") long[] roleId) {
//
//        user.setRoles(roleService.getSetOfRoles(roleId));
//        userService.addUser(user);
//        return "redirect:users";
//    }
//
//    @PostMapping(value = "/delete")
//    public String delete(@ModelAttribute("user") User user) {
//                userService.remove(user);
//        return "redirect:users";
//    }
//
//    @GetMapping(value = "/edit")
//    @ResponseBody
//    public User edit(Long id) {
//        return userService.getOne(id);
//    }


//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers() {
//        return ResponseEntity.ok(userService.getAll());
//    }
//
//    @GetMapping("/oneUser")
//    public ResponseEntity<User> oneUser(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("user", user);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping(value = "/users/{id}")
//    public ResponseEntity<User> findById(@PathVariable("id") int id) {
//        return ResponseEntity.ok(userService.getOne(id));
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<Void> create(@RequestBody User user) {
//        userService.addUser(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("users/{id}")
//    public void deleteUser(@PathVariable("id") int id) {
//        userService.remove(userService.getOne(id));
//    }

//    @PatchMapping("/users/{id}") // изменяет
//    public User updateUser(@RequestBody User user, @PathVariable("id") int id) {
//        User user1 = new User();
//
//        return userService.addUser(user1);
//    }



