package com.amwell.faqsupport.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

public class JwtTokenService {

    // --- Configuration ---
    // A secure, Base64-encoded secret key
    private static final String SECRET_KEY_STRING = "9g6XUeHnAT3fTkBarHXev4SU9GpFEAUJIg/NxawPN1I=";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY_STRING));

    // Token validity in milliseconds
    private static final long ACCESS_TOKEN_VALIDITY_MS = 15 * 60 * 1000; // 15 minutes
    private static final long REFRESH_TOKEN_VALIDITY_MS = 7 * 24 * 60 * 60 * 1000; // 7 days

    // --- Token Generation ---

    /**
     * Generates both an access token and a refresh token for a given user.
     * @param username The subject of the token.
     * @param role The user's role.
     * @return A Pair of strings containing the access token and refresh token.
     */
    public static TokenPair generateTokenPair(String username, String role) {
        String accessToken = generateToken(username, role, ACCESS_TOKEN_VALIDITY_MS);
        String refreshToken = generateRefreshToken(username, REFRESH_TOKEN_VALIDITY_MS);
        return new TokenPair(accessToken, refreshToken);
    }

    /**
     * Generates a standard JWT token.
     * @param username The subject of the token.
     * @param role The user's role.
     * @param expirationMillis The token's validity duration.
     * @return The signed JWT token.
     */
    private static String generateToken(String username, String role, long expirationMillis) {
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
     * Generates a refresh token with a unique ID (JTI).
     * @param username The subject of the token.
     * @param expirationMillis The token's validity duration.
     * @return The signed refresh token.
     */
    private static String generateRefreshToken(String username, long expirationMillis) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMillis);
        String jti = UUID.randomUUID().toString(); // Add a unique identifier

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiration)
                .id(jti)
                .signWith(SECRET_KEY)
                .compact();
    }

    // --- Token Validation ---

    /**
     * Validates a token's signature and expiration.
     * @param token The JWT token string.
     * @return true if the token is valid, false otherwise.
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey)SECRET_KEY)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }

    // --- Token Claim Extraction ---

    /**
     * Extracts claims (payload) from a valid JWT token.
     * @param token The JWT token string.
     * @return The claims object.
     */
    public static Claims extractClaims(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .verifyWith((SecretKey)SECRET_KEY)
                    .build()
                    .parseSignedClaims(token);
            return jws.getPayload();
        } catch (JwtException e) {
            System.err.println("Error extracting claims: " + e.getMessage());
            return null;
        }
    }

    // --- Helper Class for Return Type ---
    public static class TokenPair {
        public final String accessToken;
        public final String refreshToken;

        public TokenPair(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

    // --- Main Method for Demonstration ---

    public static void main(String[] args) throws InterruptedException {
        String username = "testuser";
        String role = "ROLE_USER";

        System.out.println("--- 1. Initial login: Generating token pair ---");
        TokenPair initialTokens = generateTokenPair(username, role);
        System.out.println("Access Token: " + initialTokens.accessToken);
        System.out.println("Refresh Token: " + initialTokens.refreshToken);

        System.out.println("\n--- 2. Making requests with the access token (within 15 minutes) ---");
        if (validateToken(initialTokens.accessToken)) {
            Claims claims = extractClaims(initialTokens.accessToken);
            System.out.println("Access granted for user: " + claims.getSubject());
        }

        System.out.println("\n--- 3. Simulating access token expiration ---");
        // Wait for 16 minutes to simulate expiration
        // Thread.sleep(ACCESS_TOKEN_VALIDITY_MS + 60000);

        System.out.println("Wait 16 minutes...");
        // After 16 minutes, the access token will be invalid.
        System.out.println("Is initial access token still valid? " + validateToken(initialTokens.accessToken));

        System.out.println("\n--- 4. Refreshing the token using the refresh token ---");
        if (validateToken(initialTokens.refreshToken)) {
            // In a real app, this would be an API call to a /refresh endpoint
            System.out.println("Refresh token is valid. Generating new token pair...");
            Claims claims = extractClaims(initialTokens.refreshToken);
            TokenPair refreshedTokens = generateTokenPair(claims.getSubject(), claims.get("role", String.class));
            System.out.println("New Access Token: " + refreshedTokens.accessToken);
            System.out.println("New Refresh Token: " + refreshedTokens.refreshToken);
        } else {
            System.out.println("Refresh token is invalid or expired. User must re-login.");
        }
    }
}

