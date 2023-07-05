package org.example.controllers;

import org.example.entities.MyUser;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public MyUser createUser(@RequestBody MyUser myUser){
        return userService.createUser(myUser);
    }

    @GetMapping("/{id}")
    public MyUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
