package com.example.rollingFoods.rollingFoodsApp.controllers;

import ch.qos.logback.core.util.StringUtil;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
@CrossOrigin(origins = "http://localhost:8686")
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
    @PutMapping(value = "/updateFoodTruck" , consumes = "multipart/form-data")
    public ResponseEntity <FoodTruckDTO> updateFoodTruck(@RequestParam ("ownerId") Long id, @RequestPart("foodTruck") MultipartFile foodTruckFile) throws IOException {
        FoodTruckDTO foodTruck = objectMapper.readValue(foodTruckFile.getInputStream(), FoodTruckDTO.class);
        final FoodTruckDTO updatedFoodTruck = truckService.updateTruck(id, foodTruck);
        return ResponseEntity.ok(updatedFoodTruck);
    }



    // Get food truck by owner id
    @GetMapping("/foodTruckByOwnerId")
    public ResponseEntity <Long> getFoodTruckByOwnerId(@RequestParam ("ownerId")Long ownerId) {
        return ResponseEntity.ok(truckService.getTruckByOwnerId(ownerId));
    }

    // Delete food truck
    @DeleteMapping("/deleteFoodTruck")
    public ResponseEntity<Void> deleteFoodTruck(@RequestParam("foodTruckId") int id) {
        truckService.deleteTruck(id);
        return ResponseEntity.noContent().build();
    }

    // Rate food truck
    @PutMapping("/rateFoodTruck")
    public ResponseEntity<FoodTruckDTO> rateFoodTruck(@RequestParam("foodTruckId") Long truckId, @RequestParam("rating") int rating) {
        final FoodTruckDTO ratedFoodTruck = truckService.rateTruck(truckId, rating);
        return ResponseEntity.ok(ratedFoodTruck);
    }

    // Open food truck
    @PutMapping("/openFoodTruck")
    public ResponseEntity<FoodTruckDTO> openFoodTruck(@RequestParam("foodTruckId") Long truckId , @RequestBody FoodTruckDTO foodTruckDTO) {
        final FoodTruckDTO openedFoodTruck = truckService.openTruck(truckId, foodTruckDTO);
        return ResponseEntity.ok(openedFoodTruck);
    }

    // Close food truck
    @PutMapping("/closeFoodTruck")
    public ResponseEntity<FoodTruckDTO> closeFoodTruck(@RequestParam("foodTruckId") Long truckId) {
        final FoodTruckDTO closedFoodTruck = truckService.closeTruck(truckId);
        return ResponseEntity.ok(closedFoodTruck);
    }

    // Find if food truck is open
    @GetMapping("/isFoodTruckOpen")
    public ResponseEntity<Boolean> isFoodTruckOpen(@RequestParam("foodTruckId") Long id) {
        return ResponseEntity.ok(truckService.findStatusById(id));
    }

    //upload image
    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("foodTruckId") Long foodTruckId) {

        try {
            truckService.uploadProfileImage(file, foodTruckId);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Image upload failed");
        }
    }



}
