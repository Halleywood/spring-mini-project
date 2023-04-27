package com.example.springminiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationAlreadyExistsException extends RuntimeException{
    private String message;

    public InformationAlreadyExistsException(String message) {
        super(message);
    }
}
