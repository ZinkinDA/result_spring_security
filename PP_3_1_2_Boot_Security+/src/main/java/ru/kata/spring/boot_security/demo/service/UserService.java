package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void updateUser(int id,User user);

}
