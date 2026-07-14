package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    // Simple thread-safe cache to manage active session authentication states
    private final Map<String, String> tokenStorage = new ConcurrentHashMap<>();

    public String generateToken(String username, String role) {
        String token = UUID.randomUUID().toString();
        // Stores role and token validation data for cross-tier dashboard customization
        tokenStorage.put(token, username + ":" + role);
        return token;
    }

    public boolean validateToken(String token) {
        return tokenStorage.containsKey(token);
    }

    public String getRoleFromToken(String token) {
        if (!validateToken(token)) return null;
        String data = tokenStorage.get(token);
        return data.split(":")[1]; // Extracts user role context parameter
    }

    public void invalidateToken(String token) {
        tokenStorage.remove(token);
    }
}
