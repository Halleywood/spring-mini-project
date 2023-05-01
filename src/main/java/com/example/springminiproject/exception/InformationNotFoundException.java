package com.example.springminiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    /**
     * custom throw error to let developer know runtime error
     * @param error message
     * returns custom error message in server log.
     */
    public InformationNotFoundException(String message) {
        super(message);
    }
}
