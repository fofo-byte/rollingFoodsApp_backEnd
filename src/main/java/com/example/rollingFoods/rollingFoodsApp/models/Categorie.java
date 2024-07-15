package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Long id;
    private String name;
    private String description;

    /*@ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;
    */
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public Categorie() {
    }

    public Categorie(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
