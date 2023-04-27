package com.example.springminiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{

    private String message;

    public InformationNotFoundException(String message) {
        super(message);
    }
}
