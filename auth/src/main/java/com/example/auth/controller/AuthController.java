package com.example.auth.controller;

import com.example.auth.dto.AuthRequest;
import com.example.auth.entity.JwtResponse;
import com.example.auth.entity.UserCredential;
import com.example.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential userCredential){
        return authService.saveUser(userCredential);
    }

    @PostMapping("/token")
    public JwtResponse getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
        return authService.generateToken(authRequest.getUsername());
        }
        else {
           throw new RuntimeException("invalid access");
        }

    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "Token is valid";
    }
}
