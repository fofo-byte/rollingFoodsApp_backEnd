package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckOwnerDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;

import java.util.List;

public interface FoodTruckOwnerService {

    // Registering the FoodTruckOwner
    UserCredential registerFoodTruckUser(UserCredentialDTO userCredentialDTO);

    // add a food truck owner to the database
    FoodTruckOwnerDTO addFoodTruckOwner(Long userCredentialId, FoodTruckOwnerDTO foodTruckOwnerDTO);

    //get FoodTruckOwnerId by userCredentialId
    Long findFoodTruckOwnerIdByUserCredentialId(Long userCredentialId);
}
