package com.example.rollingFoods.rollingFoodsApp.models;


import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    private String email;
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

    public FoodTruckOwner() {
    }

    public FoodTruckOwner(Long id, String firstname, String lastname, String email, String phoneNumber, String tva, String bankNumber, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.tva = tva;
        this.bankNumber = bankNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<FoodTruck> getFoodTrucks() {
        return foodTrucks;
    }

    public void setFoodTrucks(Set<FoodTruck> foodTrucks) {
        this.foodTrucks = foodTrucks;
    }
}
