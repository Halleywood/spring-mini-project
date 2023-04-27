package com.example.springminiproject.service;

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
        return chickenRepository.save(chickenObject);
    }
    public void updateChicken(){};
    public void deleteChicken(){}
    //--------------------------------------------------------------CRUD EGG METHODS
    public void getAllEggs(){};
    public void getOneEgg(){};
    public void createEgg(){};
    public void updateEgg(){};
    public void deleteEgg(){}
}
