package com.example.rollingFoods.rollingFoodsApp.enums;

public enum RentalRequestStatus {

    WAITING("En attente"),
    ACCEPTED("Accepté"),
    REFUSED("Refusé");

    public final String value;

    private RentalRequestStatus(String value) {
        this.value = value;
    }
}
