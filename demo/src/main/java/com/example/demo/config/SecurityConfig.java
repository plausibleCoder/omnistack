package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // <-- CORRECT IMPORT
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This bean configures the main security rules for HTTP requests.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs (JWT)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // Endpoints for login/registration are public
                .anyRequest().authenticated()              // All other requests require authentication
            );
        return http.build();
    }

    /**
     * This bean provides user details to Spring Security. We're using a simple
     * in-memory implementation for demonstration purposes.
     * In a real app, you would implement this service to fetch users from a database.
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("password123"))
            .roles("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("adminpass"))
            .roles("ADMIN", "USER")
            .build();

        // The return type InMemoryUserDetailsManager implements the UserDetailsService interface
        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * This bean defines the password hashing algorithm. BCrypt is the standard.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * This bean exposes the AuthenticationManager, which is used by our
     * login controller to trigger the authentication process.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
