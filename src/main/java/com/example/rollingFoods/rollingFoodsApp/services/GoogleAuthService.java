package com.example.rollingFoods.rollingFoodsApp.services;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;




import com.google.api.client.http.javanet.NetHttpTransport;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleAuthService {

    private String clientId = "631494973899-vmce573ocnl2mu2pann8fnl8fpel5lb8.apps.googleusercontent.com";

    public GoogleIdToken.Payload verifyToken(String idTokenString) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(clientId))
                .build();
        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (GeneralSecurityException | IOException | java.io.IOException e) {
            e.printStackTrace();
        }
        if (idToken != null) {
            return idToken.getPayload();
        } else {
            return null;
        }
    }
}
