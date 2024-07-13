package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu, Long> {
}
