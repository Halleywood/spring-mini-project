package com.example.springminiproject.repository;

import com.example.springminiproject.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

//this interface extends JPARepo, handles requests from service class, only class that connects to DB via JPA.
//can create custom methods or use JPA built in methods to retrieve data from DB.
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
    //will need more custom methods when user and security built into app.
    Chicken findByBreed(String breed);

    Chicken findByUserIdAndBreed(Long userId, String breed);

    Chicken findByUserIdAndId(Long userId, Long chickenId);

}
