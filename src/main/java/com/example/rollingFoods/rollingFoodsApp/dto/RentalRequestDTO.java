package com.example.rollingFoods.rollingFoodsApp.dto;

import com.example.rollingFoods.rollingFoodsApp.enums.RentalRequestStatus;

import java.util.Date;

public class RentalRequestDTO {

    private Long id;
    private RentalRequestStatus status;
    private String message;
    private String response;
    private Long locationSiteId;
    private Long foodTruckOwnerId;
    private Long locationOwnerId;
    private Date dateRequest;
    private Date dateResponse;
    private Date dateStartLocation;
    private Date dateEndLocation;


    public RentalRequestDTO() {
    }

    public RentalRequestDTO(Long id, RentalRequestStatus status, String message, String response, Long locationSiteId, Long foodTruckOwnerId, Long locationOwnerId, Date dateRequest, Date dateResponse, Date dateStartLocation, Date dateEndLocation) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.response = response;
        this.locationSiteId = locationSiteId;
        this.foodTruckOwnerId = foodTruckOwnerId;
        this.locationOwnerId = locationOwnerId;
        this.dateRequest = dateRequest;
        this.dateResponse = dateResponse;
        this.dateStartLocation = dateStartLocation;
        this.dateEndLocation = dateEndLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentalRequestStatus getStatus() {
        return status;
    }

    public void setStatus(RentalRequestStatus status) {
        this.status = status;
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

    public Long getLocationSiteId() {
        return locationSiteId;
    }

    public void setLocationSiteId(Long locationSiteId) {
        this.locationSiteId = locationSiteId;
    }

    public Long getFoodTruckOwnerId() {
        return foodTruckOwnerId;
    }

    public void setFoodTruckOwnerId(Long foodTruckOwnerId) {
        this.foodTruckOwnerId = foodTruckOwnerId;
    }

    public Long getLocationOwnerId() {
        return locationOwnerId;
    }

    public void setLocationOwnerId(Long locationOwnerId) {
        this.locationOwnerId = locationOwnerId;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Date getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(Date dateResponse) {
        this.dateResponse = dateResponse;
    }

    public Date getDateStartLocation() {
        return dateStartLocation;
    }

    public void setDateStartLocation(Date dateStartLocation) {
        this.dateStartLocation = dateStartLocation;
    }

    public Date getDateEndLocation() {
        return dateEndLocation;
    }

    public void setDateEndLocation(Date dateEndLocation) {
        this.dateEndLocation = dateEndLocation;
    }
}
