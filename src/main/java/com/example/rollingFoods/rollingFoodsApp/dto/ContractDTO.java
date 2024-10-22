package com.example.rollingFoods.rollingFoodsApp.dto;

import com.example.rollingFoods.rollingFoodsApp.enums.TypeContract;

import java.util.Date;

public class ContractDTO {

    private Long id;
    private TypeContract typeContract;
    private Date dateStart;
    private Date dateEnd;
    private String description;
    private Double price;
    private Date dateSignature;
    private Boolean signedFoodTruckOwner;
    private Boolean signedLocationOwner;
    private Boolean signedHelloFoods;


    public ContractDTO() {
    }

    public ContractDTO(Long id, TypeContract typeContract, Date dateStart, Date dateEnd, String description, Double price, Date dateSignature, Boolean signedFoodTruckOwner, Boolean signedLocationOwner, Boolean signedHelloFoods) {
        this.id = id;
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

    public TypeContract getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(TypeContract typeContract) {
        this.typeContract = typeContract;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
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

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
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
