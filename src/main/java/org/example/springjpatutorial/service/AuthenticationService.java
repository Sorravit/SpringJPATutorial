package org.example.springjpatutorial.service;

import lombok.extern.log4j.Log4j2;
import org.example.springjpatutorial.model.authorization.User;
import org.example.springjpatutorial.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(User input) {
        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(input);
    }

    public User authenticate(User input) {
        log.debug("Authenticating user : {}", input.getUsername());
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    input.getUsername(),
                    input.getPassword()
            );
            authenticationManager.authenticate(authentication);
        } catch (Exception e) {
            log.debug("Authentication failed for user : {}", input.getUsername());
            log.debug("Exception : {}", e.getMessage());
            throw e;
        }
        log.debug("Authentication successful for user : {}", input.getUsername());
        return userRepository.findByUsername(input.getUsername()).orElseThrow();
    }
}