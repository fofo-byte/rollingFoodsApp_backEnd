package com.example.rollingFoods.rollingFoodsApp.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_truck")

public class FoodTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_food_truck")
    private Long id;
    private String name;
    private String description;
    @Column(name = "food_type")
    private String foodType;
    private Float length;
    private Float width;
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "foodTruck", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Menu> menus = new HashSet<>();

    public FoodTruck() {
    }

    public FoodTruck(Long id, String name, String description,String foodType, Float length, Float width) {
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

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
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

    public Set<Menu> getMenus() {
        return menus;
    }
    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
