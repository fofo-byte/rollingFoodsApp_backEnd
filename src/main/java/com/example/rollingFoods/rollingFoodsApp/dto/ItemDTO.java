package com.example.rollingFoods.rollingFoodsApp.dto;

import java.math.BigDecimal;

public record ItemDTO(
        String name,
        String description,
        Integer pricepriceExclTva,
        String foodType

) {
}
