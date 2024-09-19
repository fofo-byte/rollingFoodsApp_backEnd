package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.enums.ItemCategorie;
import com.example.rollingFoods.rollingFoodsApp.models.Item;

import java.util.List;

public interface ItemService {



    public List<ItemDTO> getAllItems();
    public ItemDTO getItemById(Long id);
    public Item addItem(Item item);
    //Update item
    public ItemDTO updateItem(Long id, ItemDTO itemDTO);
    //Delete item
    public void deleteItem(Long id);
    //public List<ItemDTO> getItemsByCategorieId(Long categorieId);
    public Item addItemToCategorie(ItemDTO itemDTO);
    //public List<ItemDTO> getItemsByFoodTruckId(Long foodTruckId);

    ItemDTO addItemToFoodTruck(ItemDTO itemDTO);

    Item addItemToFoodTruck(ItemDTO itemDTO, Long foodTruckId);
    List<ItemDTO> getItemsByFoodTruckId(Long foodTruckId);
    List<ItemDTO> getItemsByCategory(String category);
    public List<ItemDTO> getItemsByFoodTruckIdAndCategory(Long foodTruckId, String category);
}
