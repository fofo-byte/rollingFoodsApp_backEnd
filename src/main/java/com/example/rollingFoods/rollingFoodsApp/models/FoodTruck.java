package com.example.rollingFoods.rollingFoodsApp.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

import com.example.rollingFoods.rollingFoodsApp.models.Picture;

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
    private LocalDate createdDate = LocalDate.now();

    //Relation ManyToOne avec FoodTruckOwner car un foodTruck appartient à un foodTruckOwner
    @ManyToOne
    @JoinColumn(name = "id_food_truck_owner")
    @JsonBackReference
    private FoodTruckOwner foodTruckOwner;

    //Relation OneToMany avec Menu car un foodTruck peut contenir plusieurs menus
    @OneToMany(mappedBy ="foodTruck", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Menu> menus = new HashSet<>();

    //Relation OneToMany avec Picture car un foodTruck peut contenir plusieurs images
    @OneToMany(mappedBy = "foodTruck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Picture> pictures = new ArrayList<>();


    public FoodTruck() {
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public FoodTruckOwner getFoodTruckOwner() {
        return foodTruckOwner;
    }

    public void setFoodTruckOwner(FoodTruckOwner foodTruckOwner) {
        this.foodTruckOwner = foodTruckOwner;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
