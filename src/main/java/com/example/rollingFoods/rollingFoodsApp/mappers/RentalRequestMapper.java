package com.example.rollingFoods.rollingFoodsApp.mappers;


import com.example.rollingFoods.rollingFoodsApp.dto.RentalRequestDTO;
import com.example.rollingFoods.rollingFoodsApp.models.RentalRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalRequestMapper {

    RentalRequest dtoToRentalRequest(RentalRequestDTO dto);
    RentalRequestDTO rentalRequestToDto(RentalRequest rentalRequest);
}
