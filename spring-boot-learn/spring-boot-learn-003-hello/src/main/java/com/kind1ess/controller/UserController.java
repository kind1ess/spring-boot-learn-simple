package com.kind1ess.controller;


import com.kind1ess.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/authUser")
    public User authUser(@RequestBody @Valid User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user;
    }
}
