package com.example.springminiproject.service;

import com.example.springminiproject.model.Chicken;
import com.example.springminiproject.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
//This service class handles requests from the controller, deals with the business logic, connects to repository for DB retrival.
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    //--------------------------------------------------------------CRUD CHICKEN METHODS
    public List<Chicken> getAllChickens(){
        return chickenRepository.findAll();
    };
    public void getOneChicken(){};
    public void createChicken(){};
    public void updateChicken(){};
    public void deleteChicken(){}
    //--------------------------------------------------------------CRUD EGG METHODS
    public void getAllEggs(){};
    public void getOneEgg(){};
    public void createEgg(){};
    public void updateEgg(){};
    public void deleteEgg(){}
}
