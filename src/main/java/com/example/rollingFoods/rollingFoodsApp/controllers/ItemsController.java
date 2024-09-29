package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.enums.ItemCategorie;
import com.example.rollingFoods.rollingFoodsApp.models.Item;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8686")
@RestController
public class ItemsController {

    // Injecting the ItemService
    @Autowired
    private ItemService itemService;

    // Get all items
    @GetMapping("/items")
    public ResponseEntity <List<ItemDTO>> getItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
    // Get item by id
    @GetMapping("/items/{id}")
    public ResponseEntity <ItemDTO> getItemById(@PathVariable("id") Long itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }

    /*
    // Get items by category id
    @GetMapping("/items/categorie/{categorieId}")
    public ResponseEntity <List<ItemDTO>> getItemsByCategorieId(@PathVariable("categorieId") Long categorieId) {
        return ResponseEntity.ok(itemService.getItemsByCategorieId(categorieId));
    }

     */
    //
    @PostMapping("/items")
    public ResponseEntity <Item> createItem(@RequestBody ItemDTO itemDTO, @RequestParam("foodTruckId") Long foodTruckId) {
        Item Item = itemService.addItemToFoodTruck(itemDTO, foodTruckId);
        return ResponseEntity.ok(Item);
    }

    //Get items by food truck id
    @GetMapping("/items/foodTruck")
    public ResponseEntity <List<ItemDTO>> getItemsByFoodTruckId(@RequestParam("foodTruckId") Long foodTruckId) {
        return ResponseEntity.ok(itemService.getItemsByFoodTruckId(foodTruckId));
    }

    // Get items by category
    @GetMapping("/items/category")
    public ResponseEntity <List<ItemDTO>> getItemsByCategory(@RequestParam("category") String category) {
        return ResponseEntity.ok(itemService.getItemsByCategory(category));
    }

    // Get items by food truck id and category
    @GetMapping("/items/foodTruckAndCategory")
    public ResponseEntity<List<ItemDTO>> getItemsByFoodTruckIdAndCategory(
            @RequestParam("foodTruckId") Long foodTruckId,
            @RequestParam("category") String category) {
        return ResponseEntity.ok(itemService.getItemsByFoodTruckIdAndCategory(foodTruckId, category));
    }

    // Update item
    @PutMapping("/items/{id}")
    public ResponseEntity <ItemDTO> updateItem(@PathVariable("id") Long itemId, @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.updateItem(itemId,itemDTO));
    }

    // Delete item
    @DeleteMapping("/items/{id}")
    public ResponseEntity <Void> deleteItem(@PathVariable("id") Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.ok().build();
    }








}
