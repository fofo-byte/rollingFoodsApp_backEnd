package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.SubCategorieDTO;
import com.example.rollingFoods.rollingFoodsApp.services.SubCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCategorieController {

    @Autowired
    private SubCategorieService subCategorieService;


    @PostMapping("/subCategorie")
    public ResponseEntity <SubCategorieDTO> createSubCategorie(SubCategorieDTO subCategorieDTO, Long categorieId) {
        return ResponseEntity.ok(subCategorieService.addSubCategorieToCategory(categorieId, subCategorieDTO));
    }
}
