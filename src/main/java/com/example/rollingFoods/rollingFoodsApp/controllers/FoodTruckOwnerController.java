package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckOwnerDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.services.FoodTruckOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodTruckOwnerController {

    private static final Logger logger =  LoggerFactory.getLogger(CategorieController.class);

    // Injecting the FoodTruckOwnerService
    @Autowired
    private FoodTruckOwnerService foodTruckOwnerService;

    // Registering the FoodTruckOwner
    @PostMapping("/registerFoodTruckOwner")
     ResponseEntity<UserCredential> registerFoodTruckOwner(@RequestBody @Validated UserCredentialDTO UserCredentialDTO) {
        logger.info("Registering FoodTruckOwner: {}", UserCredentialDTO);
        UserCredential registerFoodTruckOwner = foodTruckOwnerService.registerFoodTruckUser(UserCredentialDTO);
        return ResponseEntity.ok(registerFoodTruckOwner);
    }

    // add a food truck owner to the database
    @PostMapping("/addFoodTruckOwner")
    public ResponseEntity<FoodTruckOwnerDTO> addFoodTruckOwner(@RequestParam Long userCredentialId, @RequestBody FoodTruckOwnerDTO foodTruckOwnerDTO) {
        logger.info("Adding FoodTruckOwner: {}", foodTruckOwnerDTO);
        FoodTruckOwnerDTO addFoodTruckOwner = foodTruckOwnerService.addFoodTruckOwner(userCredentialId, foodTruckOwnerDTO);
        return ResponseEntity.ok(addFoodTruckOwner);
    }
}
