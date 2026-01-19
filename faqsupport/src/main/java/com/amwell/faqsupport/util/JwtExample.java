package com.amwell.faqsupport.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

public class JwtExample {

    private static final String SECRET_KEY_STRING = "9g6XUeHnAT3fTkBarHXev4SU9GpFEAUJIg/NxawPN1I=";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY_STRING));

    /**
     * Generates a new JWT token.
     * @param username The subject of the token (e.g., the user's name).
     * @param role The user's role (e.g., "ROLE_USER").
     * @param expirationMillis The token's validity duration in milliseconds.
     * @return The signed JWT token as a string.
     */
    public static String generateToken(String username, String role, long expirationMillis) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
    }

    /**
     * Validates a JWT token's signature and expiration.
     * @param token The JWT token string.
     * @return true if the token is valid, false otherwise.
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) SECRET_KEY)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }

    /**
     * Extracts claims (payload) from a valid JWT token.
     * @param token The JWT token string.
     * @return The claims (payload) as a Claims object, or null if invalid.
     */
    public static Claims extractClaims(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                   .verifyWith((SecretKey) SECRET_KEY)
                    .build()
                    .parseSignedClaims(token);
            return jws.getPayload();
        } catch (JwtException e) {
            System.err.println("Error extracting claims: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Generating a new token ---");
        String username = "adminuser";
        String role = "ROLE_ADMIN";
        long oneHour = 3600000;
        String jwtToken = generateToken(username, role, oneHour);
        System.out.println("Generated Token: " + jwtToken);

        System.out.println("\n--- Validating the token ---");
        boolean isValid = validateToken(jwtToken);
        System.out.println("Is token valid? " + isValid);

        if (isValid) {
            System.out.println("\n--- Extracting claims ---");
            Claims claims = extractClaims(jwtToken);
            if (claims != null) {
                System.out.println("Subject (Username): " + claims.getSubject());
                System.out.println("Role: " + claims.get("role", String.class));
                System.out.println("Expiration: " + claims.getExpiration());
            }
        }

        System.out.println("\n--- Testing with a corrupted token ---");
        String tamperedToken = jwtToken + "corruption";
        System.out.println("Is tampered token valid? " + validateToken(tamperedToken));
    }
}





