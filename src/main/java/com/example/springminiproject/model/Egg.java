package com.example.springminiproject.model;

public class Egg {
    private String color;
    private String shape;
    private Integer size;

    //---------------------------------------------CONSTRUCTORS
    //---------------------------------------------ONE EGG TO ONE CHICKEN
    //---------------------------------------------GETTERS AND SETTERS


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                ", size=" + size +
                '}';
    }
}
