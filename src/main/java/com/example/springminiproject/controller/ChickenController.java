package com.example.springminiproject.controller;
import com.example.springminiproject.model.User;
import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.model.Egg;
import com.example.springminiproject.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *handles all of the http requests and calls correct service method to handle the business logic
 */
@RestController
@RequestMapping(path = "/api") //http://localhost:9092/api
public class ChickenController {

    private ChickenService chickenService;
    @Autowired
    public void setChickenService(ChickenService chickenService) {
        this.chickenService = chickenService;
    }

    //-------------------------------------------------------------------------------CHICKEN CRUD OPERATIONS

     /**
     *      * returns ALL of the chickens in the database, regardless of who created them.
     *      * @param no parameters
     *      * @return List of Chicken objects.
     *      */
    @GetMapping(path="/chickens")
    public List<Chicken> getChickens(){
        return chickenService.getAllChickens();
    }
    /**
     * returns one chicken based on its ids.
     * @param one path variable, passes to service!
     * @return Chicken of id.
     */
    //GET ONE CHICKEN
    @GetMapping(path="/chickens/{chickenId}")
    public Chicken getOneChicken(@PathVariable Long chickenId){
        return chickenService.getOneChicken(chickenId);
    }
    /**
     * Allows user to create a new chicken.
     * @param none, passes request body to service
     * @return the new chicken object.
     */
    //CREATE CHICKEN
    @PostMapping(path="/chickens")
    public Chicken createChicken(@RequestBody Chicken chickenObject){
        return chickenService.createChicken(chickenObject);
    }
    /**
     * IF you are the user who created the chicken object, you can modify it.
     * @param chickenId from url and passes it to service.
     * @return updated chicken object.
     */
    //UPDATE CHICKEN
    @PutMapping(path="/chickens/{chickenId}")
    public Chicken updateChicken(@PathVariable Long chickenId, @RequestBody Chicken chicken){
        return chickenService.updateChicken(chickenId, chicken);
    }
    /**
     * IF you are the user who created the chicken object, you can delete it.
     * @param chickenId from url and passes it to service.
     * @return updated chicken object.
     */
    //DELETE CHICKEN
    @DeleteMapping(path="/chickens/{chickenId}")
    public Chicken deleteChicken(@PathVariable Long chickenId){
        return chickenService.deleteChicken(chickenId);
    }
    //------------------------------------------------------------------------------------EGG CRUD OPERATIONS
    /**
     * returns ALL of the eggs in the database, regardless of who created them.
     * @param no parameters
     * @return List of Egg objects.
     */
    //GET ALL EGGS
    @GetMapping(path="/chickens/eggs")
    public List<Egg> getEggs(){
        return chickenService.getEggs();
    }
    /**
     * returns ONE egg, regardless of who created it
     * @param chickenId and eggId from URL
     * @return one Egg.
     */
    //GET ONE EGG
    @GetMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg getOneEgg(@PathVariable Long chickenId, @PathVariable Long eggId){
        return chickenService.getOneEgg(chickenId, eggId);
    }
    /**
     * IF you are the user who created the chicken object, you can create an Egg for it.
     * @param chickenId from url and passes it to service.
     * @return Egg object with one-to-one relationship to a chicken.
     */
    //CREATE EGG
    @PostMapping(path="/chickens/{chickenId}/eggs")
    public Egg createEgg(@PathVariable Long chickenId, @RequestBody Egg eggObject){
        return chickenService.createEgg(chickenId, eggObject);
    }
    /**
     * IF you are the user who created the chicken object, you can update an Egg for it.
     * @param chickenId and the eggId from url and passes it to service.
     * @return updated Egg object
     */
    //UPDATE EGG
    @PutMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg updateEgg(@PathVariable Long chickenId, @PathVariable Long eggId, @RequestBody Egg eggObject){
        return chickenService.updateEgg(chickenId, eggId, eggObject);
    }
    /**
     * IF you are the user who created the chicken object, you can delete the Egg for it.
     * @param chickenId and the eggId from url and passes it to service.
     * @return deleted Egg object
     */
    //DELETE EGG
    @DeleteMapping(path="/chickens/{chickenId}/eggs/{eggId}")
    public Egg deleteEgg(@PathVariable Long chickenId, @PathVariable Long eggId){
        return chickenService.deleteEgg(chickenId, eggId);
    }
    //------------------------------------------------------------------------------------GET ALL USER's LIKED CHICKENS?
    /**
     *I do not want to submit with dangling code, but I want to come back and make these Many-To-Many relationship queries work so I do not want to omit them!
     */
//    @GetMapping(path="/user/likes")
//    public List<Chicken> allLikedChickensOfUser(){
//        return chickenService.getAllUserLikedChickens();
//
//    //------------------------------------------------------------------------------------GET ALL USERNAMES THAT LIKE A CHICKEN BY ID?

    /**
     * Will look at length of Likes in chicken object and return an integer, not the users!
     * @param chickenId
     * @return
     */
    @GetMapping(path="/chickens/{chickenId}/likes")
    public Integer chickenTotalLikes(@PathVariable Long chickenId){
        return chickenService.getChickenTotalLikes(chickenId);
    }
//    //------------------------------------------------------------------------------------A USER CAN LIKE A CHICKEN?

    /**
     * sends chickenId to service, finds that chicken object and adds user to its list of Users that "like it"
     * @param chickenId
     * @return a String letting user know they have liked that chicken
     */
    @GetMapping(path="/chickens/like/{chickenId}")
    public String likeChicken(@PathVariable Long chickenId){
        chickenService.likeAChicken(chickenId);
        return "you liked the " + chickenService.getOneChicken(chickenId).getBreed();
    }
}
