package com.example.rollingFoods.rollingFoodsApp.dto;

import com.example.rollingFoods.rollingFoodsApp.models.Picture;

import java.math.BigDecimal;

public class ItemDTO


 {
    private String name;
    private double price;
    private String description;
    private String foodType;
    private Picture picture;
    private Long subCategorieId;

    public ItemDTO() {
    }

    public ItemDTO(String name, double price, String description, String foodType, Picture picture, Long subCategorieId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.foodType = foodType;
        this.picture = picture;
        this.subCategorieId = subCategorieId;
    }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public String getFoodType() {
         return foodType;
     }

     public void setFoodType(String foodType) {
         this.foodType = foodType;
     }

     public Picture getPicture() {
         return picture;
     }

     public void setPicture(Picture picture) {
         this.picture = picture;
     }

     public Long getSubCategorieId() {
         return subCategorieId;
     }

     public void setSubCategorieId(Long subCategorieId) {
         this.subCategorieId = subCategorieId;
     }
 }
