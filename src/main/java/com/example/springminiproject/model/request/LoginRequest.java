package com.example.springminiproject.model.request;

public class LoginRequest {
    private String email;
    private String password;

    //not setting anything, just to get information from the user!
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
