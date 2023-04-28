package com.example.springminiproject.repository;

import com.example.springminiproject.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EggRepository extends JpaRepository<Egg, Long> {

}
