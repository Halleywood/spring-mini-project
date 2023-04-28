package com.example.springminiproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="profiles")
public class UserProfile {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String profileDescription;
    //.....................................................................CONSTRUCTORS

    public UserProfile() {}

    public UserProfile(Long id, String firstName, String lastName, String profileDescription) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileDescription = profileDescription;
    }
    //.............................................................ONE USER TO ONE PROFILE
    @OneToOne(mappedBy = "userProfile")
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //..........................................................GETTERS/SETTERS/TO STRING

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                '}';
    }
}
