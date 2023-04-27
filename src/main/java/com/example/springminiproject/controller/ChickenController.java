package com.example.springminiproject.controller;

import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api") //http://localhost:9092/api
//this class handles http requests, connects to service layer.
public class ChickenController {

    private ChickenService chickenService;
    @Autowired
    public void setChickenService(ChickenService chickenService) {
        this.chickenService = chickenService;
    }

    //---------------------------------------------CHICKEN CRUD OPERATIONS
    //GET ALL CHICKENS
    @GetMapping(path="/chickens")
    public List<Chicken> getChickens(){
        return chickenService.getAllChickens();
    }
    //GET ONE CHICKEN
    @GetMapping(path="/chickens/{chickenId}")
    public Chicken getOneChicken(@PathVariable Long chickenId){
        return chickenService.getOneChicken(chickenId);
    }
    //CREATE CHICKEN
    @PostMapping(path="/chickens")
    public Chicken createChicken(@RequestBody Chicken chickenObject){
        return chickenService.createChicken(chickenObject);
    }
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
