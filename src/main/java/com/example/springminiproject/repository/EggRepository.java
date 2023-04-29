package com.example.springminiproject.repository;

import com.example.springminiproject.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EggRepository extends JpaRepository<Egg, Long> {
    Egg findByChickenIdAndId(Long chickenId, Long eggId);
}
