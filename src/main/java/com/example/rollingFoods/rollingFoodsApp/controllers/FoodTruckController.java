package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodTruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/foodTruck")
    public ResponseEntity <List<FoodTruck>> getFoodTruck() {
        return ResponseEntity.ok(truckService.);
    }

    @GetMapping("/foodTruck/{id}")
    public ResponseEntity <FoodTruck> getFoodTruckById(int id) {
        FoodTruck truck = truckService.getTruckById(id);
        if (truck.getId() == 0) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(truck);
        }
    }

    @PostMapping("/foodTruck")
    public ResponseEntity <FoodTruck> saveFoodTruck(FoodTruck truck) {
        return ResponseEntity.ok(truckService.createTruck(truck));
    }


}
