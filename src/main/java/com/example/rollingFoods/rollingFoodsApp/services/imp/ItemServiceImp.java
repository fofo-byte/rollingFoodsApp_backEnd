package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.ItemMapper;
import com.example.rollingFoods.rollingFoodsApp.models.Categorie;
import com.example.rollingFoods.rollingFoodsApp.models.Item;
import com.example.rollingFoods.rollingFoodsApp.repositories.CategorieRepo;
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

    public List<ItemDTO> getItemsByCategorieId(Long categorieId) {
        final Set<Item> items = categorieRepo.findById(categorieId).orElseThrow(()->new RuntimeException("Categorie not found")).getItems();
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

    public Item addItemToCategorie(ItemDTO itemDTO) {
        Categorie categorie = categorieRepo.findById(itemDTO.getCategorieId()).orElseThrow(()->new RuntimeException("Categorie not found"));
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPriceExclTva(itemDTO.getPrice());
        item.setDescription(itemDTO.getDescription());
        item.setFoodType(itemDTO.getFoodType());
        item.setCategorie(categorie);

        return itemRepo.save(item);
    }
}
