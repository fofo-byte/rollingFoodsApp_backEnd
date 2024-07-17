package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sub_categorie")
public class SubCategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_categorie")
    private Long id;
    private String name;

    /*
    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "subCategorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Item> items;
    */
    public SubCategorie() {
    }

    public SubCategorie(Long id, String name) {
        this.id = id;
        this.name = name;

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


}