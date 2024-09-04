package com.example.rollingFoods.rollingFoodsApp.enums;

public enum FoodType {
    FAST_FOOD ( "Fast Food" ),
    MEXICAN(    "Mexican" ),
    ITALIAN("Italian"),
    CHINESE("Chinese"),
    JAPANESE("Japanese"),
    INDIAN("Indian"),
    MEDITERRANEAN("Mediterranean"),
    AMERICAN("American"),
    FRENCH("French"),
    SPANISH("Spanish"),
    GREEK("Greek"),
    GERMAN("German"),
    KOREAN("Korean"),
    THAI("Thai"),
    VIETNAMESE("Vietnamese"),
    TURKISH("Turkish");


    public final String value;

    private FoodType(String value) {
        this.value = value;
    }


}
