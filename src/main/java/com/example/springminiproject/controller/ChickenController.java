package com.example.springminiproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api") //http://localhost:9092/api
//this class handles http requests, connects to service layer.
public class ChickenController {

    @GetMapping(path="/test")//http://localhost:9092/api/test
    public String testMethod(){
        return "IT WORKS";
    }

    //---------------------------------------------CHICKEN CRUD OPERATIONS
    //GET ALL CHICKENS
    @GetMapping(path="/chickens")
    public void getChickens(){};
    //GET ONE CHICKEN
    @GetMapping(path="/chickens/{chickenId}")
    public void getOneChicken(){};
    //CREATE CHICKEN
    @PostMapping(path="/chickens")
    public void createChicken(){};
    //UPDATE CHICKEN
    @PutMapping(path="/chickens/{chickenId}")
    public void updateChicken(){};
    //DELETE CHICKEN
    @DeleteMapping(path="/chickens/{chickenId}")
    public void deleteChicken(){}
    //---------------------------------------------EGG CRUD OPERATIONS
    //GET ALL EGGS
    @GetMapping(path="/chickens/eggs")
    public void getEggs(){};
    //GET ONE EGG
    @GetMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public void getOneEgg(){};
    //CREATE EGG
    @PostMapping(path="/chickens/{chickenId}/eggs")
    public void createEgg(){};
    //UPDATE EGG
    @PutMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public void updateEgg(){};
    //DELETE EGG
    @DeleteMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public void deleteEgg(){}
}
