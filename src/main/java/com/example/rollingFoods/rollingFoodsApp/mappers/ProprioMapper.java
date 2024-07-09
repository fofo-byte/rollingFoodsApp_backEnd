package com.example.rollingFoods.rollingFoodsApp.mappers;


import com.example.rollingFoods.rollingFoodsApp.dto.ProprioDTO;
import com.example.rollingFoods.rollingFoodsApp.models.Proprio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProprioMapper {
    @Mapping(target = "id", ignore = true)
    Proprio dtoToProprio(ProprioDTO dto);
    ProprioDTO proprioToDto(Proprio proprio);
}
