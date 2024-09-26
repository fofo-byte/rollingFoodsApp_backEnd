package com.example.rollingFoods.rollingFoodsApp.services;

import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;

public interface UserService {
    public UserCredential registerUser(UserCredentialDTO userCredentialDTO);
    public String signIn (UserCredentialDTO userCredentialDTO);
    public void validateToken(String token);



}
