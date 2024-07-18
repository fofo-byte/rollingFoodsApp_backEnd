package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "article")
public class Item {

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
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedDate = LocalDateTime.now();


    //Relation ManyToOne avec Categorie car un item appartient à une catégorie
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_picture", referencedColumnName = "id_picture")
    private Picture picture;
    */
    public Item() {}

    public Item(Long id, String name, String description, String foodType, Float priceExclTva, Categorie categorie) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodType = foodType;
        this.priceExclTva = priceExclTva;
        this.categorie = categorie;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }


}

