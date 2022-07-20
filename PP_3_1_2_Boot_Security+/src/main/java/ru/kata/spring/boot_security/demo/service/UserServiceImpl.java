package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    public void saveUser(User user){
        userDao.saveUser(user);
    }

    public void deleteUser(Integer id){
        userDao.deleteUser(id);
    }

    public List<User> getAllUsers(){
        return userDao.getUserAll();
    }

    public User getUserById(Integer id){
        return userDao.getUserIndex(id);
    }

    public void updateUser(int id,User user){
        userDao.updateUser(id,user);
    }
    

}
