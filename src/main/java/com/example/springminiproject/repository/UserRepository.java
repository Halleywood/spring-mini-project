package com.example.springminiproject.repository;

import com.example.springminiproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //will need at least two methods for service method to call.
}
