package com.example.rollingFoods.rollingFoodsApp.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Long id;

    @OneToOne
    @JoinColumn(name = "food_truck_id")
    private FoodTruck foodTruck;

    /*
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Categorie> categories;
    */
    public Menu() {
    }

    public Menu(Long id, FoodTruck foodTruck) {
        this.id = id;
        this.foodTruck = foodTruck;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }


}
