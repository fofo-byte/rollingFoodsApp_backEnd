package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTruckRepo extends JpaRepository<FoodTruck, Long> {
}
