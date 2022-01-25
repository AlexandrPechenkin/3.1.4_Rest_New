package ru.kata.spring.boot_security.demo.Dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getUser(long id);
    void addUser(User user);
    void remove(long id);
    void update(long id, User user);
}