package com.example.rollingFoods.rollingFoodsApp.models;


import com.example.rollingFoods.rollingFoodsApp.enums.RentalRequestStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RentalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_location_site" , nullable = false)
    private LocationSite locationSite;

    @ManyToOne
    @JoinColumn(name = "id_food_truck_owner" , nullable = false)
    private FoodTruckOwner foodTruckOwner;

    @ManyToOne
    @JoinColumn(name = "id_location_owner" , nullable = false)
    private LocationOwner locationOwner;

    @Enumerated(EnumType.STRING)
    private RentalRequestStatus status;

    private LocalDate dateRequest;
    private LocalDate dateResponse;
    private LocalDate dateStartLocation;
    private LocalDate dateEndLocation;
    private String message;
    private String response;

    public RentalRequest() {
    }

    public RentalRequest(Long id, LocationSite locationSite, FoodTruckOwner foodTruckOwner, LocationOwner locationOwner, RentalRequestStatus status, LocalDate dateRequest, LocalDate dateResponse, LocalDate dateStartLocation, LocalDate dateEndLocation, String message, String response) {
        this.id = id;
        this.locationSite = locationSite;
        this.foodTruckOwner = foodTruckOwner;
        this.locationOwner = locationOwner;
        this.status = status;
        this.dateRequest = dateRequest;
        this.dateResponse = dateResponse;
        this.dateStartLocation = dateStartLocation;
        this.dateEndLocation = dateEndLocation;
        this.message = message;
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationSite getLocationSite() {
        return locationSite;
    }

    public void setLocationSite(LocationSite locationSite) {
        this.locationSite = locationSite;
    }

    public FoodTruckOwner getFoodTruckOwner() {
        return foodTruckOwner;
    }

    public void setFoodTruckOwner(FoodTruckOwner foodTruckOwner) {
        this.foodTruckOwner = foodTruckOwner;
    }

    public LocationOwner getLocationOwner() {
        return locationOwner;
    }

    public void setLocationOwner(LocationOwner locationOwner) {
        this.locationOwner = locationOwner;
    }

    public RentalRequestStatus getStatus() {
        return status;
    }

    public void setStatus(RentalRequestStatus status) {
        this.status = status;
    }

    public LocalDate getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(LocalDate dateRequest) {
        this.dateRequest = dateRequest;
    }

    public LocalDate getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(LocalDate dateResponse) {
        this.dateResponse = dateResponse;
    }

    public LocalDate getDateStartLocation() {
        return dateStartLocation;
    }

    public void setDateStartLocation(LocalDate dateStartLocation) {
        this.dateStartLocation = dateStartLocation;
    }

    public LocalDate getDateEndLocation() {
        return dateEndLocation;
    }

    public void setDateEndLocation(LocalDate dateEndLocation) {
        this.dateEndLocation = dateEndLocation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
