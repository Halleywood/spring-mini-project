package com.example.springminiproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api") //http://localhost:9092/api
public class ChickenController {

    @GetMapping(path="/test")//http://localhost:9092/api/test
    public String testMethod(){
        return "IT WORKS";
    }
}
