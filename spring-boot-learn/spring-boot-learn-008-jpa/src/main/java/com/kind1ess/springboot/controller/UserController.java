package com.kind1ess.springboot.controller;

import com.kind1ess.springboot.entity.User;
import com.kind1ess.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.getOne(id);      //spring boot2把以前的findOne改成getOne了！
        return user;
    }

    @PostMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
