package com.example.rollingFoods.rollingFoodsApp.services.imp;


import com.example.rollingFoods.rollingFoodsApp.dto.LocationOwnerDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.AddressMapper;
import com.example.rollingFoods.rollingFoodsApp.mappers.LocationOwnerMapper;
import com.example.rollingFoods.rollingFoodsApp.mappers.UserCredentialMapper;
import com.example.rollingFoods.rollingFoodsApp.models.LocationOwner;
import com.example.rollingFoods.rollingFoodsApp.models.Role;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.models.embedded.Address;
import com.example.rollingFoods.rollingFoodsApp.repositories.LocationOwnerRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.RoleRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.UserCredentialRepo;
import com.example.rollingFoods.rollingFoodsApp.services.EmailService;
import com.example.rollingFoods.rollingFoodsApp.services.LocationOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LocationOwnerServiceImp implements LocationOwnerService {

    @Autowired
    private LocationOwnerRepo locationOwnerRepo;

    @Autowired
    private LocationOwnerMapper locationOwnerMapper;

    @Autowired
    private AddressMapper adressMapper;

    @Autowired
    private UserCredentialMapper userCredentialMapper;

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    public LocationOwnerServiceImp(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public LocationOwnerDTO cretateLocationOwner(Long userCredentialId, LocationOwnerDTO locationOwnerDTO) {
        UserCredential userCredential = userCredentialRepo.findById(userCredentialId).orElse(null);
        Address address = adressMapper.dtoToAddress(locationOwnerDTO.getAddress());

        LocationOwner locationOwner = new LocationOwner();
        locationOwner.setAddress(address);
        locationOwner.setFirstname(locationOwnerDTO.getFirstname());
        locationOwner.setLastname(locationOwnerDTO.getLastname());
        locationOwner.setPhoneNumber(locationOwnerDTO.getPhoneNumber());
        locationOwner.setBankNumber(locationOwnerDTO.getBankNumber());
        locationOwner.setUserCredential(userCredential);
        LocationOwner locationOwnerSave = locationOwnerRepo.save(locationOwner);


        return locationOwnerMapper.toLocationOwnerDTO(locationOwnerSave);
    }

    // Registering the LocationOwner
    @Override
    public UserCredential registerLocationOwner(UserCredentialDTO userCredentialDTO) {
        if(userCredentialDTO.getPassword() ==  null || userCredentialDTO.getPassword().isEmpty()){
            throw new IllegalArgumentException("Password cannot be empty");
        }else{
            UserCredential userCredential = userCredentialMapper.dtoToUser(userCredentialDTO);
            userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepo.findByName("ROLE_LOCATION_OWNER"));
            userCredential.setRoles(roles);
            userCredentialRepo.save(userCredential);

            return userCredential;
        }

    }

}

