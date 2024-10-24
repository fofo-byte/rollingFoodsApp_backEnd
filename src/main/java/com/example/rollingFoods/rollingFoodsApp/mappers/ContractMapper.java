package com.example.rollingFoods.rollingFoodsApp.mappers;


import com.example.rollingFoods.rollingFoodsApp.dto.ContractDTO;
import com.example.rollingFoods.rollingFoodsApp.models.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract dtoToContract(ContractDTO dto);
    ContractDTO contractToDto(Contract contract);
}

