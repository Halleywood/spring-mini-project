package com.example.springminiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationAlreadyExistsException extends RuntimeException{
    /**
     * custom throw error to let developer know runtime error
     * @param custom error message
     * returns custom error message in server log.
     */
    public InformationAlreadyExistsException(String message) {
        super(message);
    }
}
