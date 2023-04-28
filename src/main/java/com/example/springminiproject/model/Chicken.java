package com.example.springminiproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="chickens")
public class Chicken {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String breed;
    @Column
    private String description;
    @Column
    private boolean isBroody;
    @Column
    private Integer eggsPerYear;

    //---------------------------------------------CONSTRUCTORS
    public Chicken() {}

    public Chicken(Long id, String breed, String description, boolean isBroody, Integer eggsPerYear) {
        this.id = id;
        this.breed = breed;
        this.description = description;
        this.isBroody = isBroody;
        this.eggsPerYear = eggsPerYear;
    }
    //---------------------------------------------MANY USERS CAN LIKE MANY CHICKENS

    @ManyToMany(mappedBy = "chickenLikes")
    @JsonIgnore //we will connect the user to the chicken, but do not display User info in chicken table!
    List<User> likes;

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
    //---------------------------------------------One USERS CAN CREATE ONE CHICKEN
    @OneToOne(mappedBy="chicken")
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //---------------------------------------------ONE CHICKEN TO ONE EGG
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="egg_id",referencedColumnName = "id")
    private Egg eggType;

    public Egg getEggType() {
        return eggType;
    }

    public void setEggType(Egg eggType) {
        this.eggType = eggType;
    }
//---------------------------------------------GETTERS/SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBroody() {
        return isBroody;
    }

    public void setBroody(boolean broody) {
        isBroody = broody;
    }

    public Integer getEggsPerYear() {
        return eggsPerYear;
    }

    public void setEggsPerYear(Integer eggsPerYear) {
        this.eggsPerYear = eggsPerYear;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", description='" + description + '\'' +
                ", isBroody=" + isBroody +
                ", eggsPerYear=" + eggsPerYear +
                '}';
    }
}
