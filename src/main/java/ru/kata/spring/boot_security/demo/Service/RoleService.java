package ru.kata.spring.boot_security.demo.Service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    Role getOne(long id);
    List<Role> getAll();
    HashSet<Role> getSetOfRoles(long[] roleId);
    void relation(User user, long[] roleId);
}
