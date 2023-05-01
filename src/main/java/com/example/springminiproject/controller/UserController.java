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
    /**
     * dependency injection, creates a userService instance for entire application, so controller can call service class!
     */
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    /**
     * takes request body with a unique email and password, sends to userService.
     * @param userObject
     * @return User
     */
    @PostMapping(path="/register")
    public User registerAUser(@RequestBody User userObject){
        return userService.registerAUser(userObject);
    }

    /**
     * takes Login Request model passes it to service
     * @param loginRequest
     * @return ResponseEntity<User>
     */
    @PostMapping(path="/login")
    public ResponseEntity<?> loginAsUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

}
