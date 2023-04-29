package com.example.springminiproject.controller;
import com.example.springminiproject.model.User;
import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.model.Egg;
import com.example.springminiproject.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api") //http://localhost:9092/api
//this class handles http requests, calls service layer to handle the busisness logic.
public class ChickenController {

    private ChickenService chickenService;
    @Autowired
    public void setChickenService(ChickenService chickenService) {
        this.chickenService = chickenService;
    }

    //-------------------------------------------------------------------------------CHICKEN CRUD OPERATIONS
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
    public Chicken updateChicken(@PathVariable Long chickenId, @RequestBody Chicken chicken){
        return chickenService.updateChicken(chickenId, chicken);
    }
    //DELETE CHICKEN
    @DeleteMapping(path="/chickens/{chickenId}")
    public Chicken deleteChicken(@PathVariable Long chickenId){
        return chickenService.deleteChicken(chickenId);
    }
    //------------------------------------------------------------------------------------EGG CRUD OPERATIONS
    //GET ALL EGGS
    @GetMapping(path="/chickens/eggs")
    public List<Egg> getEggs(){
        return chickenService.getEggs();
    }
    //GET ONE EGG
    @GetMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg getOneEgg(@PathVariable Long chickenId, @PathVariable Long eggId){
        return chickenService.getOneEgg(chickenId, eggId);
    }
    //CREATE EGG
    @PostMapping(path="/chickens/{chickenId}/eggs")
    public Egg createEgg(@PathVariable Long chickenId, @RequestBody Egg eggObject){
        return chickenService.createEgg(chickenId, eggObject);
    }
    //UPDATE EGG
    @PutMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg updateEgg(@PathVariable Long chickenId, @PathVariable Long eggId, @RequestBody Egg eggObject){
        return chickenService.updateEgg(chickenId, eggId, eggObject);
    }
    //DELETE EGG
    @DeleteMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg deleteEgg(@PathVariable Long chickenId, @PathVariable Long eggId){
        return chickenService.deleteEgg(chickenId, eggId);
    }
    //------------------------------------------------------------------------------------GET ALL USER's LIKED CHICKENS?
//    @GetMapping(path="/user/likes")
//    public List<Chicken> allLikedChickensOfUser(){
//        return chickenService.getAllUserLikedChickens();
//
//    //------------------------------------------------------------------------------------GET ALL USERNAMES THAT LIKE A CHICKEN BY ID?
    @GetMapping(path="/chickens/{chickenId}/likes")
    public Integer chickenTotalLikes(@PathVariable Long chickenId){
        return chickenService.getChickenTotalLikes(chickenId);
    }
//    //------------------------------------------------------------------------------------A USER CAN LIKE A CHICKEN?
    //adds chicken by id to their list of likedChickens
    //adds their username to chickens list of people who like them???
    @GetMapping(path="/chickens/like/{chickenId}")
    public String likeChicken(@PathVariable Long chickenId){
        chickenService.likeAChicken(chickenId);
        return "you liked the chicken with an id of "+ chickenId;
    }
}
