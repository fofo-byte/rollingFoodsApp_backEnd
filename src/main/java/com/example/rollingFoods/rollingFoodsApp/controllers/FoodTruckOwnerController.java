package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.services.FoodTruckOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodTruckOwnerController {

    private static final Logger logger =  LoggerFactory.getLogger(CategorieController.class);

    // Injecting the FoodTruckOwnerService
    @Autowired
    private FoodTruckOwnerService foodTruckOwnerService;

    // Get all food Trucks by owner


}
