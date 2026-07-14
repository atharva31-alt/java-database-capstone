package com.project.back_end.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // Simple list structure to store inbound dynamic document representations
    private final List<Map<String, Object>> mockPrescriptionDb = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPrescription(@Valid @RequestBody Map<String, Object> prescription) {
        // Receives and stores flexible MongoDB document data configurations
        mockPrescriptionDb.add(prescription);
        return ResponseEntity.ok(prescription);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllPrescriptions() {
        return ResponseEntity.ok(mockPrescriptionDb);
    }
}
