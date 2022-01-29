package ru.kata.spring.boot_security.demo.Service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(long id);
    void addUser(User user);
    void remove(long id);
    void update(User user);
    User getUserByUsername(String name);


}