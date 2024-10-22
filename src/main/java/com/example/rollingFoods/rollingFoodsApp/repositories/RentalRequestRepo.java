package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRequestRepo extends JpaRepository<RentalRequest, Long> {

}
