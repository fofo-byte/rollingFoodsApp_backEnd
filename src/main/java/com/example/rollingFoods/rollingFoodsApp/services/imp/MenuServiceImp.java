package com.example.rollingFoods.rollingFoodsApp.services.imp;


import com.example.rollingFoods.rollingFoodsApp.dto.MenuDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.MenuMapper;
import com.example.rollingFoods.rollingFoodsApp.models.Menu;
import com.example.rollingFoods.rollingFoodsApp.repositories.MenuRepo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImp {

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private MenuMapper mapper;

    public List<MenuDTO> getAllMenus() {
        final List<Menu> menus = menuRepo.findAll();
        return menus.stream().map(mapper::menuToDto).collect(Collectors.toList());
    }
}
