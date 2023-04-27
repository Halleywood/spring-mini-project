package com.example.springminiproject.model;


import javax.persistence.*;

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
    //---------------------------------------------ONE USER TO MANY CHICKENS
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
