package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.SubCategorieDTO;

import java.util.List;

public interface ItemService {



    public List<ItemDTO> getAllItems();
    public ItemDTO getItemById(Long id);
    public ItemDTO addItem(ItemDTO itemDTO);
    public ItemDTO updateItem(ItemDTO itemDTO);
    public void deleteItem(Long id);
    public List<ItemDTO> getItemsBySubCategorieId(Long subCategorieId);
    public ItemDTO addItemToSubCategorie(Long subCategorieId, ItemDTO itemDTO);

}
