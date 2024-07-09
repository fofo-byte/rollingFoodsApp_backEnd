package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private Long id;
    private String name;
    private String description;
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "price_excl_tva")
    private Float priceExclTva;
    @Column(name = "create_at")
    private Date createdDate;

    public Article() {
    }

    public Article(Long id, String name, String description, String foodType, Float priceExclTva) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.priceExclTva = priceExclTva;
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

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Float getPriceExclTva() {
        return priceExclTva;
    }

    public void setPriceExclTva(Float priceExclTva) {
        this.priceExclTva = priceExclTva;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
