package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "food_truck")

public class FoodTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "food_type")
    private String foodType;
    private Number length;
    private Number width;
    @Column(name = "created_date")
    private Date createdDate;

    public FoodTruck() {
    }

    public FoodTruck(Long id, String name, String description,String foodType, Number length, Number width) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.length = length;
        this.width = width;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getLength() {
        return length;
    }

    public void setLength(Number length) {
        this.length = length;
    }

    public Number getWidth() {
        return width;
    }

    public void setWidth(Number width) {
        this.width = width;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
