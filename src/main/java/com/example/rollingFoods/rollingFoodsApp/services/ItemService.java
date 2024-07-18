package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.models.Item;

import java.util.List;

public interface ItemService {



    public List<ItemDTO> getAllItems();
    public ItemDTO getItemById(Long id);
    public Item addItem(Item item);
    public ItemDTO updateItem(ItemDTO itemDTO);
    public void deleteItem(Long id);
    public List<ItemDTO> getItemsByCategorieId(Long categorieId);
    public Item addItemToCategorie(ItemDTO itemDTO);

}
