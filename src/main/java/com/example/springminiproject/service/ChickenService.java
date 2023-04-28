package com.example.springminiproject.service;

import com.example.springminiproject.exception.InformationAlreadyExistsException;
import com.example.springminiproject.exception.InformationNotFoundException;
import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
//This service class handles requests from the controller, deals with the business logic, connects to repository for DB retrival.
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    //--------------------------------------------------------------CRUD CHICKEN METHODS
    public List<Chicken> getAllChickens(){
        return chickenRepository.findAll();
    };
    public Chicken getOneChicken(Long chickenId){
        Optional<Chicken> chicken =  chickenRepository.findById(chickenId);
        if(chicken.isPresent()){
            return chicken.get();
        }
        else{
            throw new InformationNotFoundException("No chicken category with id of "+ chickenId + " exists in database");
        }
    }
    public Chicken createChicken(Chicken chickenObject){
        Optional<Chicken> chicken = Optional.of(chickenRepository.findByName(chickenObject.getBreed()));
        if(chicken.isPresent()){
            throw new InformationAlreadyExistsException("This chicken breed already exists in the database, consider updating existing or create new chicken category");
        }
        else{
            return chickenRepository.save(chickenObject);
        }

    }
    public Chicken updateChicken(Long chickenId, Chicken chickenObject){
        //check eat string if not same then set new string
        Optional<Chicken> chickenToUpdate = chickenRepository.findById(chickenId);
        if(chickenToUpdate.isPresent()){
            if(!chickenToUpdate.get().getBreed().equals(chickenObject.getBreed())){
                chickenToUpdate.get().setBreed(chickenObject.getBreed());
            }
            if(!chickenToUpdate.get().getDescription().equals(chickenObject.getDescription())){
                chickenToUpdate.get().setDescription(chickenObject.getDescription());
            }
            if(chickenToUpdate.get().getEggsPerYear() != (chickenObject.getEggsPerYear())) {
                chickenToUpdate.get().setEggsPerYear(chickenObject.getEggsPerYear());
            }
            if(chickenToUpdate.get().isBroody() != chickenObject.isBroody()){
                chickenToUpdate.get().setBroody(chickenObject.isBroody());
            }
            //save chickentoupdate in db w/ repository and return
            chickenRepository.save(chickenObject);
            return chickenToUpdate.get();

        }
        else{
            throw new InformationNotFoundException("a chicken category with id of "+ chickenId + "does not exist in the database");
        }
    }
    public void deleteChicken(){}
    //--------------------------------------------------------------CRUD EGG METHODS
    public void getAllEggs(){};
    public void getOneEgg(){};
    public void createEgg(){};
    public void updateEgg(){};
    public void deleteEgg(){}
}
