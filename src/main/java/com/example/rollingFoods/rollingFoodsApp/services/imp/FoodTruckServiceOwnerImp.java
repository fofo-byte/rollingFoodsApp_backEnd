package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckOwnerMapper;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.services.FoodTruckOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTruckServiceOwnerImp implements FoodTruckOwnerService {

    // Injecting the FoodTruckOwnerRepo
    @Autowired
    private FoodTruckOwnerRepo foodTruckOwnerRepo;

    // Injecting the FoodTruckOwnerMapper
    @Autowired
    private FoodTruckOwnerMapper mapper;

    // Get all food trucks by owner



}
