package com.example.rollingFoods.rollingFoodsApp.dto;

import com.example.rollingFoods.rollingFoodsApp.models.Picture;

import java.math.BigDecimal;

public class ItemDTO


 {
    private String name;
    private Float price;
    private String description;
    private String foodType;
    //private Picture picture;
    private Long categorieId;

    public ItemDTO() {
    }

    public ItemDTO(String name, Float price, String description, String foodType,Long categorieId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.foodType = foodType;
        this.categorieId = categorieId;
    }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Float getPrice() {
         return price;
     }

     public void setPrice(Float price) {
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

     public Long getCategorieId() {
         return categorieId;
     }

     public void setCategorieId(Long subCategorieId) {
         this.categorieId = subCategorieId;
     }
 }
