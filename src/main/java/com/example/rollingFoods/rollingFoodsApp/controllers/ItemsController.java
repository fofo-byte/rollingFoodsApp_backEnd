package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.models.Item;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity <List<ItemDTO>> getItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity <ItemDTO> getItemById(@PathVariable("id") Long itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }

    @GetMapping("/items/categorie/{categorieId}")
    public ResponseEntity <List<ItemDTO>> getItemsByCategorieId(@PathVariable("categorieId") Long categorieId) {
        return ResponseEntity.ok(itemService.getItemsByCategorieId(categorieId));
    }

    @PostMapping("/items")
    public ResponseEntity <Item> createItem(@RequestBody ItemDTO itemDTO) {
        Item Item = itemService.addItemToCategorie(itemDTO);
        return ResponseEntity.ok(Item);
    }






}
