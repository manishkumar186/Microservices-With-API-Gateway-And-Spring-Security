package com.example.auth.service;

import com.example.auth.entity.JwtResponse;
import com.example.auth.entity.UserCredential;
import com.example.auth.repository.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public String saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userCredentialRepo.save(credential);
        return "User added to the system";
    }

    public JwtResponse generateToken(String username){

        String token = jwtService.generateToken(username);
        Optional<UserCredential> user = userCredentialRepo.findByName(username);

        return new JwtResponse(user,token);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
