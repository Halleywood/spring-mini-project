package com.example.springminiproject.service;

import com.example.springminiproject.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//This service class handles requests from the controller, deals with the business logic, connects to repository for DB retrival.
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    //--------------------------------------------------------------CRUD CHICKEN METHODS
    public void getAllChickens(){};
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
