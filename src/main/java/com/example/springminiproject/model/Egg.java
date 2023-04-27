package com.example.springminiproject.model;

import javax.persistence.*;

@Entity
@Table(name="eggs")
public class Egg {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String color;
    @Column
    private String shape;
    @Column
    private Double size;

    //---------------------------------------------CONSTRUCTORS

    public Egg() {}

    public Egg(Long id, String color, String shape, Double size) {
        this.id = id;
        this.color = color;
        this.shape = shape;
        this.size = size;
    }

    //---------------------------------------------ONE EGG TO ONE CHICKEN
    //---------------------------------------------GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                ", size=" + size +
                '}';
    }
}
