package com.example.springminiproject.model;

public class Chicken {
    private String breed;
    private String description;
    private boolean isBroody;
    private Integer eggsPerYear;

    //---------------------------------------------CONSTRUCTORS
    public Chicken() {}

    public Chicken(String breed, String description, boolean isBroody, Integer eggsPerYear) {
        this.breed = breed;
        this.description = description;
        this.isBroody = isBroody;
        this.eggsPerYear = eggsPerYear;
    }
    //---------------------------------------------ONE USER TO MANY CHICKENS
    //---------------------------------------------ONE CHICKEN TO ONE EGG
    //---------------------------------------------GETTERS/SETTERS

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
                "breed='" + breed + '\'' +
                ", description='" + description + '\'' +
                ", isBroody=" + isBroody +
                ", eggsPerYear=" + eggsPerYear +
                '}';
    }
}
