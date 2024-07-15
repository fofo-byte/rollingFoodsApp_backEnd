package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity <ItemDTO> getItemById(Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PostMapping("/item")
    public ResponseEntity <ItemDTO> createItem(ItemDTO itemDTO, Long subCategorieId) {
        return ResponseEntity.ok(itemService.addItem(itemDTO, subCategorieId));
    }




}
