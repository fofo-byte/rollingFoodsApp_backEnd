package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    // Injecting the UserService
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    ResponseEntity<UserCredential> registerUser(@RequestBody @Validated UserCredentialDTO userCredentialDTO) {
        logger.info("Registering User: {}", userCredentialDTO);
        UserCredential registerUser = userService.registerUser(userCredentialDTO);
        return ResponseEntity.ok(registerUser);
    }
}
