package com.example.springminiproject.security;

import com.example.springminiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository (UserRepository userRepository){ this.userRepository = userRepository;}

    //will need two methods that the controller will call too...that talk to userRepo and get user data using JPA.
}
