package com.example.rollingFoods.rollingFoodsApp.controllers;

import com.example.rollingFoods.rollingFoodsApp.component.JwtTokenProvider;
import com.example.rollingFoods.rollingFoodsApp.services.GoogleAuthService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GoogleAuthController {

    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private GoogleAuthService googleAuthService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth")
    public ResponseEntity<?> googleAuth(@RequestBody Map<String, String> body) {

        try {
            String idToken = body.get("idToken");
            GoogleIdToken.Payload payload = googleAuthService.verifyToken(idToken);

            String email = payload.getEmail();

            String jwt = jwtTokenProvider.generateTokenGoogle(email);

            return ResponseEntity.ok(jwt);

        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }

}
