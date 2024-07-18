package com.example.rollingFoods.rollingFoodsApp.repositories;

import com.example.rollingFoods.rollingFoodsApp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {

    // Find all items by category id
    List<Item> findAllById(Long categorieId);
    // Find all items by menu id
    //@Query("SELECT i FROM Item i JOIN i.categorie c JOIN c.menu m WHERE m.id = :menuId")
    //List<Item> findAllByMenuId(Long menuId);
}
