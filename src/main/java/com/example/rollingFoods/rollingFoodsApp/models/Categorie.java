package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<SubCategorie> subCategories;

    public Categorie() {
    }

    public Categorie(Long id, String name, String description, Menu menu, List<SubCategorie> subCategories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.menu = menu;
        this.subCategories = subCategories;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<SubCategorie> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategorie> subCategories) {
        this.subCategories = subCategories;
    }
}
