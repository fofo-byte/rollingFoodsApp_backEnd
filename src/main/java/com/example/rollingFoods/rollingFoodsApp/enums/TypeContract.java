package com.example.rollingFoods.rollingFoodsApp.enums;

public enum TypeContract {

    FOOD_TRUCK_OWNER( "Propriétaire de food truck"),
    LOCATION_OWNER("Propriétaire d'emplacement");

    public final String value;

    private TypeContract(String value) {
        this.value = value;
    }

}
