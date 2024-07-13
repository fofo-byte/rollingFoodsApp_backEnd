package com.example.rollingFoods.rollingFoodsApp.dto;

public record ItemDTO(
        String name,
        String description,
        double price,
        String image,
        CategorieDTO categorie,
        SubCategorieDTO subCategorie
) {
}
