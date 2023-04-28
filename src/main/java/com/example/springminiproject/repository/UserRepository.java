package com.example.springminiproject.repository;

import com.example.springminiproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //returns a true or false if the email address the user enters during registration is already in database
    boolean existsByEmailAddress(String emailAddress);

    //user enters email at sign in, uses this email to locate the user object
    User findUserByEmailAddress(String emailAddress);
}
