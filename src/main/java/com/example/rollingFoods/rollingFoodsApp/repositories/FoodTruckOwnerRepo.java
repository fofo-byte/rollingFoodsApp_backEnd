package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTruckOwnerRepo extends JpaRepository<FoodTruckOwner, Long> {
    FoodTruckOwner findByEmail(String email);
    FoodTruckOwner findByUsername(String username);

    boolean existsByEmail(String email);
}
