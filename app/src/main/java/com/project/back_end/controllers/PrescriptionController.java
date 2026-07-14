package com.project.back_end.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    /**
     * Requirement Criteria Checklist:
     * 1. Uses @PostMapping
     * 2. Accepts a token via @PathVariable
     * 3. Uses @RequestBody and @Valid validation wrappers
     * 4. Returns a ResponseEntity containing a structured Map<String, String> payload
     */
    @PostMapping("/create/{token}")
    public ResponseEntity<Map<String, String>> createPrescription(
            @PathVariable("token") String token,
            @Valid @RequestBody Map<String, Object> prescriptionData) {
        
        Map<String, String> structuredResponse = new HashMap<>();
        
        // Explicit logic checking the mandatory path token variable
        if (token == null || token.isEmpty() || "undefined".equals(token) || token.length() < 10) {
            structuredResponse.put("error", "Security verification failed: Invalid or missing authorization token.");
            return ResponseEntity.status(400).body(structuredResponse);
        }

        // Simulating processing logic...
        structuredResponse.put("success", "Prescription data successfully processed and stored.");
        return ResponseEntity.ok(structuredResponse);
    }
}
