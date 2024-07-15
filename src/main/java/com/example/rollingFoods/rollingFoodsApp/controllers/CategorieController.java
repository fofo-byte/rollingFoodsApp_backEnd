package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.CategorieDTO;
import com.example.rollingFoods.rollingFoodsApp.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    public List<CategorieDTO> getCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public CategorieDTO getCategoryById(Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping("/categorie")
    public CategorieDTO createCategorie(CategorieDTO categorieDTO) {
        return categorieService.createCategorie(categorieDTO);
    }


}
