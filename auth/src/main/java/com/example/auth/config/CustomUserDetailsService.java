package com.example.auth.config;

import com.example.auth.entity.UserCredential;
import com.example.auth.repository.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepo userCredentialRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserCredential> credential = userCredentialRepo.findByName(username);
        return credential.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with name :"+ username));
    }
}
