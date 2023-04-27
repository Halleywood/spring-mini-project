package com.example.springminiproject.repository;

import com.example.springminiproject.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

//this interface extends JPARepo, handles requests from service class, only class that connects to DB via JPA.
//can create custom methods or use JPA built in methods to retrieve data from DB.
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}
