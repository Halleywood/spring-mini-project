package com.example.springminiproject.security;

import com.example.springminiproject.exception.InformationAlreadyExistsException;
import com.example.springminiproject.model.User;
import com.example.springminiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //will need two methods that the controller will call too...that talk to userRepo and get user data using JPA.

    public User registerAUser(User userObject){
        if(!userRepository.existsByEmailAddress(userObject.getEmailAddress())){
            //then email is not already in system, so you can register them. Need to encrypt password then you can save them to DB.
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        }
        else{
            throw new InformationAlreadyExistsException("email address "+ userObject.getEmailAddress()+" is already present in database");
        }
    }
}
