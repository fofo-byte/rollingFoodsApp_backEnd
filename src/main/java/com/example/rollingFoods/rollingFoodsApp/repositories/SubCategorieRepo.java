package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.SubCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategorieRepo extends JpaRepository<SubCategorie, Long> {

}
