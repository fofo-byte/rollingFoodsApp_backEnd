package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;

public interface UserService {
    UserCredential registerUser(UserCredentialDTO userCredentialDTO);


}
