package ru.kata.spring.boot_security.demo.Service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void addUser(User user);
    void remove(User user);
    User getUserByEmail(String email);
    User getOne(long id);


}