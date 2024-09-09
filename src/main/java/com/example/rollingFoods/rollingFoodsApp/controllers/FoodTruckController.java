package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class FoodTruckController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TruckService truckService;




    // Get all food trucks
    @GetMapping("/foodTruck")
    public ResponseEntity <List<FoodTruckDTO>> getFoodTruck() {
        return ResponseEntity.ok(truckService.getTrucks());
    }

    // Get food truck by id
    @GetMapping("/foodTruck/{id}")
    private FoodTruckDTO findById(@PathVariable Long id) {
        return truckService.findTruckById(id);
    }



     //Create food truck
    @PostMapping(value = "/addFoodTruck", consumes = "multipart/form-data")
    public ResponseEntity <FoodTruckDTO> createFoodTruck(
            @RequestParam("ownerId") Long ownerId,
            @RequestPart("foodTruck") MultipartFile foodTruckFile
            )throws IOException {
        FoodTruckDTO foodTruck = objectMapper.readValue(foodTruckFile.getInputStream(), FoodTruckDTO.class);
        final FoodTruckDTO createdFoodTruck = truckService.createTruck(foodTruck,ownerId);
        return ResponseEntity.created(URI.create("/foodTruck/" + createdFoodTruck.getId())).build();
    }

    // Update food truck
    @PutMapping("/updateFoodTruck/{id}")
    public ResponseEntity <FoodTruckDTO> updateFoodTruck(@PathVariable Long id, @RequestBody FoodTruckDTO foodTruckDTO) {
        return ResponseEntity.ok(truckService.updateTruck(id, foodTruckDTO));
    }



    // Get food truck by owner id
    @GetMapping("/foodTruckByOwnerId/{ownerId}")
    public ResponseEntity <FoodTruckDTO> getFoodTruckByOwnerId(@PathVariable Long ownerId) {
        return ResponseEntity.ok(truckService.getTruckByOwnerId(ownerId));
    }





}
