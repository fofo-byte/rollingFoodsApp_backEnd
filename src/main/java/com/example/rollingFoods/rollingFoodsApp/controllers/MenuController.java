package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.MenuDTO;
import com.example.rollingFoods.rollingFoodsApp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    // Injecting the MenuService
    @Autowired
    private MenuService menuService;

    // Get all menus
    @GetMapping("/menus")
    public List<MenuDTO> getMenus() {
        return menuService.getAllMenus();
    }
    // Get menu by id
    @GetMapping("/menus/{id}")
    public MenuDTO getMenuById(@PathVariable("id")  Long id) {
        return menuService.getMenuById(id);
    }
    // Create menu
    @PostMapping("/menus")
    public MenuDTO createMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.createMenu(menuDTO);
    }
    // Get menu by truck id

    /*
    @GetMapping("/menus/truck/{foodTruckId}")
    public MenuDTO getMenusByTruckId(@PathVariable("foodTruckId") Long foodTruckId) {
        return menuService.getMenusByTruckId(foodTruckId);
    }

     */
}
