package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.SubCategorieDTO;

import java.util.List;

public interface SubCategorieService {

    public List<SubCategorieDTO> getAllSubCategories();
    public SubCategorieDTO getSubCategorieById(Long id);
    public SubCategorieDTO addSubCategorie(SubCategorieDTO subCategorieDTO);
    public SubCategorieDTO updateSubCategorie(SubCategorieDTO subCategorieDTO);
    public void deleteSubCategorie(Long id);
    public List<SubCategorieDTO> getSubCategoriesByMenuId(Long menuId);
    public SubCategorieDTO addSubCategorieToCategory(Long categoryId, SubCategorieDTO subCategorieDTO);

}
