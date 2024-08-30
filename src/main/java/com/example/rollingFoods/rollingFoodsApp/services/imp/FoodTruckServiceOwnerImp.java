package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.FoodTruckOwnerMapper;
import com.example.rollingFoods.rollingFoodsApp.mappers.UserCredentialMapper;
import com.example.rollingFoods.rollingFoodsApp.models.Role;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.repositories.FoodTruckOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.RoleRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.UserCredentialRepo;
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

    // Injecting the UserCredentialRepo
    @Autowired
    private UserCredentialMapper mapperUser;

    // Injecting the UserCredentialRepo
    @Autowired
    private UserCredentialRepo userCredentialRepo;

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
    public UserCredential registerFoodTruckUser(UserCredentialDTO userCredentialDTO) {
        if(userCredentialDTO.getPassword() ==  null || userCredentialDTO.getPassword().isEmpty()){
            throw new RuntimeException("Password is required");
        }else{
            UserCredential user = mapperUser.dtoToUser(userCredentialDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepo.findByName("ROLE_FOOD_TRUCK_OWNER"));
            user.setRoles(roles);
            userCredentialRepo.save(user);
            return mapperUser.userToDto(user);

        }
    }

}
