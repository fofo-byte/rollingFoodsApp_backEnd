package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckOwnerDTO;
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
    public ResponseEntity<FoodTruckOwnerDTO> registerFoodTruckOwner(@RequestBody @Validated FoodTruckOwnerDTO foodTruckOwnerDTO) {
        logger.info("Registering FoodTruckOwner: {}", foodTruckOwnerDTO);
       FoodTruckOwnerDTO registerFoodTruckOwner = foodTruckOwnerService.registerFoodTruckOwner(foodTruckOwnerDTO);
        return ResponseEntity.ok(registerFoodTruckOwner);
    }


}
