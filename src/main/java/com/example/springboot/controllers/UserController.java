package com.example.springboot.controllers;

import com.example.springboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        System.out.println("O id é " + id);
        Optional<User> userFound = users.stream().filter(user -> user.getId() == id).findFirst();

        if(userFound.isPresent()){
            return userFound.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list(){
        return users;
    }
}
