package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.dto.FavoriteDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.Favorite;
import com.example.rollingFoods.rollingFoodsApp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8686")
public class FavortiteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorite")
    ResponseEntity <List<FoodTruckDTO>>getFavorite(@RequestParam Long userId){ {
        if(userId == null){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(favoriteService.getFavorites(userId));
            }
        }
    }

    @PostMapping("/favorite")
    ResponseEntity <Favorite> addFavorite(@RequestParam Long userId,@RequestParam Long foodTruckId){
        if(userId == null || foodTruckId == null){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(favoriteService.addFavorite(userId, foodTruckId));
        }
    }

}
