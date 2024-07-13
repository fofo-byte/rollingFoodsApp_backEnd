package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {
}
