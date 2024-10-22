package com.example.rollingFoods.rollingFoodsApp.models;

import com.example.rollingFoods.rollingFoodsApp.enums.TypeContract;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_rental_request" , nullable = false)
    private RentalRequest rentalRequest;

    @Enumerated(EnumType.STRING)
    private TypeContract typeContract;

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String description;
    private Double price;
    private LocalDate dateSignature;
    private Boolean signedFoodTruckOwner;
    private Boolean signedLocationOwner;
    private Boolean signedHelloFoods;

    public Contract() {
    }

    public Contract(Long id, RentalRequest rentalRequest, TypeContract typeContract, LocalDate dateStart, LocalDate dateEnd, String description, Double price, LocalDate dateSignature, Boolean signedFoodTruckOwner, Boolean signedLocationOwner, Boolean signedHelloFoods) {
        this.id = id;
        this.rentalRequest = rentalRequest;
        this.typeContract = typeContract;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
        this.price = price;
        this.dateSignature = dateSignature;
        this.signedFoodTruckOwner = signedFoodTruckOwner;
        this.signedLocationOwner = signedLocationOwner;
        this.signedHelloFoods = signedHelloFoods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentalRequest getRentalRequest() {
        return rentalRequest;
    }

    public void setRentalRequest(RentalRequest rentalRequest) {
        this.rentalRequest = rentalRequest;
    }

    public TypeContract getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(TypeContract typeContract) {
        this.typeContract = typeContract;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(LocalDate dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Boolean getSignedFoodTruckOwner() {
        return signedFoodTruckOwner;
    }

    public void setSignedFoodTruckOwner(Boolean signedFoodTruckOwner) {
        this.signedFoodTruckOwner = signedFoodTruckOwner;
    }

    public Boolean getSignedLocationOwner() {
        return signedLocationOwner;
    }

    public void setSignedLocationOwner(Boolean signedLocationOwner) {
        this.signedLocationOwner = signedLocationOwner;
    }

    public Boolean getSignedHelloFoods() {
        return signedHelloFoods;
    }

    public void setSignedHelloFoods(Boolean signedHelloFoods) {
        this.signedHelloFoods = signedHelloFoods;
    }
}
