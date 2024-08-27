package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.FoodTruckOwnerDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckOwnerMapper;
import com.example.rollingFoods.rollingFoodsApp.models.FoodTruckOwner;
import com.example.rollingFoods.rollingFoodsApp.models.Role;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.RoleRepo;
import com.example.rollingFoods.rollingFoodsApp.services.FoodTruckOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FoodTruckServiceOwnerImp implements FoodTruckOwnerService {

    // Injecting the FoodTruckOwnerRepo
    @Autowired
    private FoodTruckOwnerRepo foodTruckOwnerRepo;

    // Injecting the FoodTruckOwnerMapper
    @Autowired
    private FoodTruckOwnerMapper mapper;

    // Injecting the PasswordEncoder
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    public FoodTruckServiceOwnerImp(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Registering the FoodTruckOwner
    @Override
    public FoodTruckOwnerDTO registerFoodTruckOwner(FoodTruckOwnerDTO foodTruckOwnerDTO) {
        if(foodTruckOwnerDTO.getPassword() ==  null || foodTruckOwnerDTO.getPassword().isEmpty()){
            throw new RuntimeException("Password is required");
        }else{
            return null;
        }

    }


}
