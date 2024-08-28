package com.example.rollingFoods.rollingFoodsApp.controllers;


import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/signIn")
    ResponseEntity<String> signIn(@RequestBody @Validated UserCredentialDTO userCredentialDTO) {
        logger.info("Signing In User: {}", userCredentialDTO);
        String signIn = userService.signIn(userCredentialDTO);
        logger.info("User Signed In: {}", signIn);
        return ResponseEntity.ok(signIn);
    }

    //Test jwt token
    @GetMapping("/contact")
    public String contact(){
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Authentication: {}", authentication);
        if (authentication == null || !authentication.isAuthenticated()) {
            logger.error("User is not authenticated");
            throw new RuntimeException("User is not authenticated");
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        logger.info("UserDetails: {}", userDetails);
        if (userDetails == null) {
            logger.error("UserDetails is null");
            throw new RuntimeException("UserDetails is null");
        }*/
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            String password = userDetails.getPassword();
            logger.info("Username: {}", username);
            logger.info("Password: {}", password);
            return "Welcome to Rolling Foods " + username + " " + password;

        } else if (principal instanceof String){
            String username = (String) principal;
            logger.info("Username: {}", username);
            return "Welcome to Rolling Foods " + username;
        }
        else {
            throw new RuntimeException("Principal is not an instance of UserDetails");
        }


    }

}
