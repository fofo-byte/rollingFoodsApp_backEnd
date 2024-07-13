package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
