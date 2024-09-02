package com.example.rollingFoods.rollingFoodsApp.dto;

import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodTruckOwnerDTO  extends UserDTO{

    private String companyName;
    private String tva;
    private String bankNumber;



}
