package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Controller
@RequestMapping()
public class UserController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "users";
    }
    @GetMapping("/users/{index}")
    public String getUserIndex(@PathVariable("index") int index, Model model) {
        model.addAttribute("person", userServiceImpl.getUserById(index));
        return "person";
    }
    @GetMapping("/users/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "/new";
    }
    @PostMapping("/users/new")
    public String createUser(@ModelAttribute("user") User user){
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{index}/update")
    public String updateUser(Model model,@PathVariable("index") int id){
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "/update";
    }

    @PostMapping ("/users/{index}")
    public String update(@ModelAttribute("user") User user,@PathVariable("index") int id){
        userServiceImpl.updateUser(id,user);
        return "redirect:/users";
    }
    @DeleteMapping("/users/{index}")
    public String delete(@PathVariable("index") int id){
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }

}
