package com.example.springminiproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth/users")
public class UserController {

    @GetMapping(path="/register")
    public String test(){
        return "IT WORKS! ";
    }

    @GetMapping(path="/login")
    public String test2(){
        return "this also works!";
    }

}
