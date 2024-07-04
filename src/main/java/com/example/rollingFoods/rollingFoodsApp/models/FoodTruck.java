package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_truck")

public class FoodTruck {

    @Id
    private Long id;
    private String name;
    private String description;
    private String location;
    private String foodType;

}