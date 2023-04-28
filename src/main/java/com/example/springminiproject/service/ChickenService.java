package com.example.springminiproject.service;

import com.example.springminiproject.exception.InformationAlreadyExistsException;
import com.example.springminiproject.exception.InformationNotFoundException;
import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.model.Egg;
import com.example.springminiproject.model.User;
import com.example.springminiproject.security.MyUserDetails;
import com.example.springminiproject.repository.ChickenRepository;
import com.example.springminiproject.repository.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//This service class handles requests from the controller, deals with the business logic, connects to repository for DB retrival.
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    private EggRepository eggRepository;
    @Autowired
    public void setEggRepository(EggRepository eggRepository){
        this.eggRepository = eggRepository;
    }
//--------------------------------------------------------------------------------------------GET USER INFO FROM LOG IN
    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }

    //--------------------------------------------------------------------------------------------CRUD CHICKEN METHODS
    //GET ALL CHICKENS
    public List<Chicken> getAllChickens(){
        return chickenRepository.findAll();
    };
    //GET ONE CHICKEN
    public Chicken getOneChicken(Long chickenId){
        Optional<Chicken> chicken =  chickenRepository.findById(chickenId);
        if(chicken.isPresent()){
            return chicken.get();
        }
        else{
            throw new InformationNotFoundException("No chicken category with id of "+ chickenId + " exists in database");
        }
    }
    //CREATE A CHICKEN
    public Chicken createChicken(Chicken chickenObject){
        Optional<Chicken> chicken = Optional.of(chickenRepository.findByBreed(chickenObject.getBreed()));
        if(chicken.isPresent()){
            throw new InformationAlreadyExistsException("This chicken breed already exists in the database, consider updating existing or create new chicken category");
        }
        else{
            return chickenRepository.save(chickenObject);
        }

    }
    //UPDATE EXISTING CHICKEN
    public Chicken updateChicken(Long chickenId, Chicken chickenObject){
        //check each part of chx object if not same then set new string
        Optional<Chicken> chickenToUpdate = chickenRepository.findById(chickenId);
        if(chickenToUpdate.isPresent()){
            if(!chickenToUpdate.get().getBreed().equals(chickenObject.getBreed())){
                chickenToUpdate.get().setBreed(chickenObject.getBreed());
            }
            if(!chickenToUpdate.get().getDescription().equals(chickenObject.getDescription())){
                chickenToUpdate.get().setDescription(chickenObject.getDescription());
            }
            if(!Objects.equals(chickenToUpdate.get().getEggsPerYear(), chickenObject.getEggsPerYear())) {
                chickenToUpdate.get().setEggsPerYear(chickenObject.getEggsPerYear());
            }
            if(chickenToUpdate.get().isBroody() != chickenObject.isBroody()){
                chickenToUpdate.get().setBroody(chickenObject.isBroody());
            }
            //save chickenToUpdate in db w/ repository and return
            chickenRepository.save(chickenObject);
            return chickenToUpdate.get();
        }
        else{
            throw new InformationNotFoundException("a chicken category with id of "+ chickenId + "does not exist in the database");
        }
    }
    //DELETE A CHICKEN
    public Chicken deleteChicken(@PathVariable Long chickenId){
        Optional<Chicken> chickenToDelete = chickenRepository.findById(chickenId);
        if(chickenToDelete.isPresent()){
            chickenRepository.delete(chickenToDelete.get());
            return chickenToDelete.get();
        }
        else{
            throw new InformationNotFoundException("No chicken with id of " + chickenId + " exists in the database!");
        }
    }
    //-----------------------------------------------------------------------------------------------CRUD EGG METHODS
    //GET ALL EGGS
    public List<Egg> getEggs(){

        return eggRepository.findAll();
    }
    //GET EGG OF SPECIFIC CHICKEN
    public Egg getOneEgg(@PathVariable Long chickenId, @PathVariable Long eggId){
        Chicken chicken = getOneChicken(chickenId);
        Optional <Egg> egg = Optional.of(chicken.getEggType());
        if(egg.isPresent()){
            return chicken.getEggType();
        }
        else{
            throw new InformationNotFoundException("No chickens with id of " + chickenId );
        }
    }
    //CREATE AN EGG
    public Egg createEgg(Long chickenId, Egg eggObject){
        Optional<Chicken> chicken = chickenRepository.findById(chickenId);
        if(chicken.isPresent()){
            eggObject.setChicken(chicken.get());
            chicken.get().setEggType(eggObject);
            eggRepository.save(eggObject);
            return eggObject;
        }
       else{
           throw new InformationNotFoundException("No chicken with id of " + chickenId + " exists in the database");
        }
    }
    //UPDATE AN EGG OF A SPECIFIC CHICKEN
    public Egg updateEgg(Long chickenId, Long eggId, Egg eggObject){
        Chicken chicken = getOneChicken(chickenId);
        if(chicken != null){
            Optional <Egg> egg = Optional.of(eggRepository.findByChickenIdAndId(chickenId, eggId));
            if(egg.isPresent()){
                if(!egg.get().getColor().equals(eggObject.getColor())){
                    egg.get().setColor(eggObject.getColor());
                }
                if(!egg.get().getSize().equals(eggObject.getSize())){
                    egg.get().setSize(eggObject.getSize());
                }
                if(!egg.get().getShape().equals(eggObject.getShape())){
                    egg.get().setShape(eggObject.getShape());
                }
                eggRepository.save(egg.get());
                return egg.get();
            }
            else{
                throw new InformationNotFoundException("No egg with id of "+ eggId+" exists for this chicken");
            }
        }
        else {
            throw new InformationNotFoundException("No chicken with an id of " + chickenId + " in the database");
        }
    }
    //DELETE AN EGG OF A SPECIFIC CHICKEN
    public Egg deleteEgg(Long chickenId, Long eggId){
        Chicken chicken = getOneChicken(chickenId);
        if(chicken != null){
            Optional <Egg> egg = Optional.of(eggRepository.findByChickenIdAndId(chickenId,eggId));
            if(egg.isPresent()){
                eggRepository.delete(egg.get());
                return egg.get();
            }
            else{
                throw new InformationNotFoundException("an egg with id of " + eggId + "does not exist in the database, unable to delete!");
            }
        }
        else{
            throw new InformationNotFoundException("a chicken with id of "+ chickenId+ " does not exist in the database, unable to delete");
        }
    }

    //GET ALL CHICKENS A USER LIKES! MANY TO MANY
    public List<Chicken> getAllChickensAUserLikes(){
        Optional <User> user = Optional.of(getCurrentLoggedInUser());
        if(user.isPresent()){
            return user.get().getChickenLikes();
        }
        else{
            throw new InformationNotFoundException("No user exists with this id");
        }
    }

    //GET ALL USERNAMES THAT LIKE A CHICKEN
    public List<User> getAllUsersThatLikeAChicken(Long chickenId){
        Chicken chicken = getOneChicken(chickenId);
        if(chicken != null){
            return chicken.getLikes();
        }
        else{
            throw new InformationNotFoundException("no chicken with that id exists in database");
        }
    }

    //USER LIKES A CHICKEN, ADDS THEIR USERNAME TO THE CHICKENS LIST OF PEOPLE THAT LIKE THEM
    public void likeAChicken(Long chickenId){
        Chicken chicken = getOneChicken(chickenId);
        chicken.getLikes().add(getCurrentLoggedInUser());
        getCurrentLoggedInUser().getChickenLikes().add(chicken);
    }
}
