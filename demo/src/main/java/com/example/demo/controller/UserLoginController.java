package com.example.demo.controller;

// In package com.example.demo.controller

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;


@RestController
@RequestMapping("/api/auth") // Common base path for auth-related endpoints
public class UserLoginController {

    private final AuthenticationManager authenticationManager;

    // We inject the AuthenticationManager bean we configured in SecurityConfig
    public UserLoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        // The AuthenticationManager will use the UserDetailsService and PasswordEncoder
        // to check if the user's credentials are correct.
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );

        // If authentication is successful, the 'authentication' object will contain the
        // authenticated user's details (including roles).
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // For now, we'll just return a success message.
        // In the NEXT step, we will generate and return a JWT here.
        return ResponseEntity.ok("Login Successful!");
    }
}
