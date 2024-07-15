package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.ItemDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.ItemMapper;
import com.example.rollingFoods.rollingFoodsApp.models.Item;
import com.example.rollingFoods.rollingFoodsApp.repositories.ItemRepo;
import com.example.rollingFoods.rollingFoodsApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper mapper;

    public List<ItemDTO> getAllItems() {
        final List<Item> items = itemRepo.findAll();
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }

    public ItemDTO addItem(ItemDTO itemDTO, Long subCategorieId) {
        final Item item = mapper.dtoToItem(itemDTO);
        final Item saved = itemRepo.save(item);
        return mapper.itemToDto(saved);
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
        final Item item = itemRepo.findById(id).orElse
                (new Item());
        return mapper.itemToDto(item);
    }
    /*
    public List<ItemDTO> getItemsBySubCategorieId(Long subCategorieId) {
        final List<Item> items = itemRepo.findBySubCategorieId(subCategorieId);
        return items.stream().map(mapper::itemToDto).collect(Collectors.toList());
    }
    */
    public ItemDTO addItemToSubCategorie(Long subCategorieId, ItemDTO itemDTO) {
        final Item newItem = mapper.dtoToItem(itemDTO);
        final Item saved = itemRepo.save(newItem);
        return mapper.itemToDto(saved);
    }
}
