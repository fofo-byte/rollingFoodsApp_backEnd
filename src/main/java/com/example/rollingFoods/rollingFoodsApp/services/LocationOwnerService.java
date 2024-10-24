package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.LocationOwnerDTO;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.LocationOwner;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;

public interface LocationOwnerService {

    public LocationOwnerDTO cretateLocationOwner(Long userCredentialId, LocationOwnerDTO locationOwnerDTO);
    public UserCredential registerLocationOwner(UserCredentialDTO userCredentialDTO);
}
