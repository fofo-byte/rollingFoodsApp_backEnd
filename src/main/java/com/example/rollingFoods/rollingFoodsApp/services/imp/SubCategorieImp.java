package com.example.rollingFoods.rollingFoodsApp.services.imp;


import com.example.rollingFoods.rollingFoodsApp.dto.SubCategorieDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.SubCategorieMapper;
import com.example.rollingFoods.rollingFoodsApp.models.SubCategorie;
import com.example.rollingFoods.rollingFoodsApp.repositories.SubCategorieRepo;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import com.example.rollingFoods.rollingFoodsApp.services.SubCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategorieImp implements SubCategorieService {

    @Autowired
    private SubCategorieRepo subCategorieRepo;

    @Autowired
    private SubCategorieMapper mapper;


    public List<SubCategorieDTO> getAllSubCategories() {
        final List<SubCategorie> subCategories = subCategorieRepo.findAll();
        return subCategories.stream().map(mapper::subCategorieToDto).collect(Collectors.toList());
    }

    public SubCategorieDTO addSubCategorie(SubCategorieDTO subCategorieDTO) {
        final SubCategorie newSubCategorie = mapper.dtoToSubCategorie(subCategorieDTO);
        final SubCategorie saved = subCategorieRepo.save(newSubCategorie);
        return mapper.subCategorieToDto(saved);
    }

    public SubCategorieDTO updateSubCategorie(SubCategorieDTO subCategorieDTO) {
        final SubCategorie subCategorie = mapper.dtoToSubCategorie(subCategorieDTO);
        final SubCategorie updated = subCategorieRepo.save(subCategorie);
        return mapper.subCategorieToDto(updated);
    }

    public void deleteSubCategorie(Long id) {
        subCategorieRepo.deleteById(id);
    }

    public SubCategorieDTO getSubCategorieById(Long id) {
        final SubCategorie subCategorie = subCategorieRepo.findById(id).orElse
                (new SubCategorie());
        return mapper.subCategorieToDto(subCategorie);
    }

    public List<SubCategorieDTO> getSubCategoriesByMenuId(Long categoryId) {
        final List<SubCategorie> subCategories = subCategorieRepo.findByCategorieId(categoryId);
        return subCategories.stream().map(mapper::subCategorieToDto).collect(Collectors.toList());
    }

    public SubCategorieDTO addSubCategorieToCategory(Long categoryId, SubCategorieDTO subCategorieDTO) {
        final SubCategorie newSubCategorie = mapper.dtoToSubCategorie(subCategorieDTO);
        final SubCategorie saved = subCategorieRepo.save(newSubCategorie);
        return mapper.subCategorieToDto(saved);
    }


}
