package com.example.springminiproject.service;

import com.example.springminiproject.exception.InformationAlreadyExistsException;
import com.example.springminiproject.model.User;
import com.example.springminiproject.model.request.LoginRequest;
import com.example.springminiproject.model.response.LoginResponse;
import com.example.springminiproject.repository.UserRepository;
import com.example.springminiproject.security.JWTUtils;
import com.example.springminiproject.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwUtils;
    private AuthenticationManager authenticationManager;
    private MyUserDetails myUserDetails;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy MyUserDetails myUserDetails) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
    }

    //---------------------------------------------------------------------------------------------REGISTER A USER IN DB.
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
    //------------------------------------------------------------------------------------------------------LOGIN A USER
    //responseEntity returns a key value pair, ? = Object
    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            myUserDetails = (MyUserDetails) authentication.getPrincipal();
            final String JWT = jwUtils.generateJwtToken(myUserDetails);
            return ResponseEntity.ok(new LoginResponse(JWT));
        }
        catch(Exception e){
            return ResponseEntity.ok(new LoginResponse("Error: username or password is incorrect"));
        }
    }
    //---------------------------------------------------------------------FIND A USER BY EMAIL FOR USER DETAILS SERVICE
    public User findUserByEmailAddress(String emailAddress){
        return userRepository.findUserByEmailAddress(emailAddress);
    }
}
