package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture")
    private Long id;
    private String description;
    private String url;

    /*
    @OneToOne
    @JoinColumn(name = "id_item")
    private Item item;
    */
    public Picture() {
    }

    public Picture(Long id, String description, String url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
