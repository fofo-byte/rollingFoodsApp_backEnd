package com.example.rollingFoods.rollingFoodsApp.services.imp;

import com.example.rollingFoods.rollingFoodsApp.component.JwtTokenProvider;
import com.example.rollingFoods.rollingFoodsApp.dto.UserCredentialDTO;
import com.example.rollingFoods.rollingFoodsApp.mappers.UserCredentialMapper;
import com.example.rollingFoods.rollingFoodsApp.models.Role;
import com.example.rollingFoods.rollingFoodsApp.models.UserCredential;
import com.example.rollingFoods.rollingFoodsApp.repositories.RoleRepo;
import com.example.rollingFoods.rollingFoodsApp.repositories.UserCredentialRepo;
import com.example.rollingFoods.rollingFoodsApp.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private UserCredentialMapper mapperUser;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public UserServiceImp(PasswordEncoder passwordEncoder) {
    }


    //Register user method
    @Override
    public UserCredential registerUser(UserCredentialDTO userCredentialDTO) {
        if(userCredentialDTO.getPassword() ==  null || userCredentialDTO.getPassword().isEmpty()){
            throw new RuntimeException("Password is required");
        }else{
            UserCredential user = mapperUser.dtoToUser(userCredentialDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepo.findByName("ROLE_USER"));
            user.setRoles(roles);
            userCredentialRepo.save(user);
            return mapperUser.userToDto(user);


        }

    }
    //Sign in method
    @Override
    public String signIn(UserCredentialDTO userCredentialDTO) {
            try {
                UserCredential user = userCredentialRepo.findByEmail(userCredentialDTO.getEmail());
                if (user == null) {
                    throw new RuntimeException("User not found");
                } else if (!passwordEncoder.matches(userCredentialDTO.getPassword(), user.getPassword())) {
                    throw new RuntimeException("Password incorrect");
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
                return jwtTokenProvider.generateToken(authentication);

            } catch (Exception e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }

    }


}
