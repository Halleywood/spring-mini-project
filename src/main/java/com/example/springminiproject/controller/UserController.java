package com.example.springminiproject.controller;

import com.example.springminiproject.model.User;
import com.example.springminiproject.model.request.LoginRequest;
import com.example.springminiproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth/users")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @PostMapping(path="/register")
    public User registerAUser(@RequestBody User userObject){
        return userService.registerAUser(userObject);
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginAsUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

}
