package com.example.rollingFoods.rollingFoodsApp.mappers;


import com.example.rollingFoods.rollingFoodsApp.dto.SubCategorieDTO;
import com.example.rollingFoods.rollingFoodsApp.models.SubCategorie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubCategorieMapper {
    @Mapping(target = "id", ignore = true)
    SubCategorie dtoToSubCategorie(SubCategorieDTO dto);
    SubCategorieDTO subCategorieToDto(SubCategorie subCategorie);
}
