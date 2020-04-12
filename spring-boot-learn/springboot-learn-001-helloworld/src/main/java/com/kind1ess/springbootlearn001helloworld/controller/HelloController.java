package com.kind1ess.springbootlearn001helloworld.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody String hello(){
        return "Hello World!";
    }
}
