package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;
    private String name;
    private String description;
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "price_excl_tva")
    private Double priceExclTva;
    @Column(name = "create_at")
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_sub_categorie" , referencedColumnName = "id_sub_categorie")
    private SubCategorie subCategorie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_picture", referencedColumnName = "id_picture")
    private Picture picture;

    public Item() {}

    public Item(Long id, String name, String description, String foodType, Double priceExclTva, SubCategorie subCategorie, Picture picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.priceExclTva = priceExclTva;
        this.subCategorie = subCategorie;
        this.picture = picture;
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

    public Double getPriceExclTva() {
        return priceExclTva;
    }

    public void setPriceExclTva(Double priceExclTva) {
        this.priceExclTva = priceExclTva;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public SubCategorie getSubCategorie() {
        return subCategorie;
    }

    public void setSubCategorie(SubCategorie subCategorie) {
        this.subCategorie = subCategorie;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }


}
