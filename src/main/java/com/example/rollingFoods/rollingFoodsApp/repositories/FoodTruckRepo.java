package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodTruckRepo extends JpaRepository<FoodTruck, Long> {
    //Find food truck by  food truck owner id
    @Query("SELECT f.id FROM FoodTruck f WHERE f.foodTruckOwner.id = :foodTruckOwnerId")
    Long findByFoodTruckOwnerId(Long foodTruckOwnerId);
}
