package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserAll();

    User getUserIndex(int index);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
