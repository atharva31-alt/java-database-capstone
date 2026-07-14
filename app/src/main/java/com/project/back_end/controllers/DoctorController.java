package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    // Mock list to act as data layer placeholder until repositories are bound
    private final List<Doctor> mockDoctorDb = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        // Enforces payload checks via @Valid on inbound DTO structure
        mockDoctorDb.add(doctor);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        // Extracts the route parameter segment cleanly from the URI path
        return mockDoctorDb.stream()
                .filter(d -> d.getId() != null && d.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(mockDoctorDb);
    }
}
