package com.example.rollingFoods.rollingFoodsApp.models;


import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food_truck_owner")
public class FoodTruckOwner extends User {

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "tva_number")
    private String tva;
    @Column(name = "bank_number")
    private String bankNumber;



    //Relation OneToMany avec FoodTruck car un foodTruckOwner peut avoir plusieurs foodTruck
    @OneToMany(mappedBy = "foodTruckOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FoodTruck> foodTrucks = new HashSet<>();

    //Relation ManyToOne avec UserCredential car un foodTruckOwner appartient à un UserCredential
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserCredential userCredential;









}
