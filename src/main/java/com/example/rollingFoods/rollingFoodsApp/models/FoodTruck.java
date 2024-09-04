package com.example.rollingFoods.rollingFoodsApp.models;


import com.example.rollingFoods.rollingFoodsApp.enums.FoodType;
import com.example.rollingFoods.rollingFoodsApp.models.embedded.Coordinates;
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
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String speciality;
    private Coordinates coordinates;
    private Float length;
    private Float width;
    private Boolean isOpen = false;
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

    public FoodTruck(Long id, String name, String description, FoodType foodType, String speciality, Coordinates coordinates, Float length, Float width, Boolean isOpen, LocalDate createdDate, FoodTruckOwner foodTruckOwner, Set<Menu> menus, List<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.speciality = speciality;
        this.coordinates = coordinates;
        this.length = length;
        this.width = width;
        this.isOpen = isOpen;
        this.createdDate = createdDate;
        this.foodTruckOwner = foodTruckOwner;
        this.menus = menus;
        this.pictures = pictures;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }
}
