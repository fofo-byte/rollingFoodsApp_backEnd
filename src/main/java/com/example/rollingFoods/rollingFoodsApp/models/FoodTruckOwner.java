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
public class FoodTruckOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_food_truck_owner")
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String tva;
    @Column(name = "bank_number")
    private String bankNumber;
    @Column(name = "create_at")
    private String createdDate;
    private Address address;

    //Relation OneToMany avec FoodTruck car un foodTruckOwner peut avoir plusieurs foodTruck
    @OneToMany(mappedBy = "foodTruckOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FoodTruck> foodTrucks = new HashSet<>();

    //Relation ManyToOne avec UserCredential car un foodTruckOwner appartient à un UserCredential
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserCredential userCredential;









}
