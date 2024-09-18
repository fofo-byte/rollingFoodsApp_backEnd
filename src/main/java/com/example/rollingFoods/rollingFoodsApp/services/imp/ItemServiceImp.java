package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.enums.ItemCategorie;
import com.example.rollingFoods.rollingFoodsApp.mappers.ItemMapper;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruck;
import com.example.rollingFoods.rollingFoodsApp.models.Item;
import com.example.rollingFoods.rollingFoodsApp.repositories.CategorieRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.ItemRepo;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper mapper;

    @Autowired
    private CategorieRepo categorieRepo;

    @Autowired
    private FoodTruckRepo foodTruckRepo;

    public List<ItemDTO> getAllItems() {
        final List<Item> items = itemRepo.findAll();
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    public ItemDTO updateItem(ItemDTO itemDTO) {
        final Item item = mapper.dtoToItem(itemDTO);
        final Item updated = itemRepo.save(item);
        return mapper.itemToDto(updated);
    }

    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }

    public ItemDTO getItemById(Long id) {
        final Item item = itemRepo.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
        return mapper.itemToDto(item);
    }

    /*
    public List<ItemDTO> getItemsByCategorieId(Long categorieId) {
        final Set<Item> items = categorieRepo.findById(categorieId).orElseThrow(()->new RuntimeException("Categorie not found")).getItems();
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

     */

    @Override
    public Item addItemToCategorie(ItemDTO itemDTO) {
        return null;
    }



    @Override
    public ItemDTO addItemToFoodTruck(ItemDTO itemDTO) {
        return null;
    }


    //Add new item to food truck
    @Override
    public Item addItemToFoodTruck(ItemDTO itemDTO, Long foodTruckId) {
        final FoodTruck foodTruck = foodTruckRepo.findById(foodTruckId).orElseThrow(()->new RuntimeException("Food truck not found"));
        final Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        item.setItemCategorie(itemDTO.getItemCategorie());
        item.setPictureItem(itemDTO.getPictureItem());
        item.setFoodTruck(foodTruck);

        return itemRepo.save(item);
    }
    //Get items by food truck id
    @Override
    public List<ItemDTO> getItemsByFoodTruckId(Long foodTruckId) {
        final List <Item> items = itemRepo.findByFoodTruckId(foodTruckId);
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

    //Get items by category
    @Override
    public List<ItemDTO> getItemsByCategory(String category) {
        ItemCategorie itemCategorieEnum = ItemCategorie.valueOf(category);  // Convertir la chaîne en enum
        List<Item> items = itemRepo.findByItemCategorie(itemCategorieEnum);
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

    //Get items by food truck id and category
    @Override
    public List<ItemDTO> getItemsByFoodTruckIdAndCategory(Long foodTruckId, String category) {
        ItemCategorie itemCategorieEnum = ItemCategorie.valueOf(category);  // Convertir la chaîne en enum
        List<Item> items = itemRepo.findByFoodTruckIdAndItemCategorie(foodTruckId, itemCategorieEnum);
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

}


