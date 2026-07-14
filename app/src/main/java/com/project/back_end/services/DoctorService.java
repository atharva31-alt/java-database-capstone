package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final List<Doctor> doctorDatabase = new ArrayList<>();

    public Doctor saveDoctor(Doctor doctor) {
        // Core layer business logic processing implementation
        doctorDatabase.add(doctor);
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return doctorDatabase;
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorDatabase.stream()
                .filter(d -> d.getId() != null && d.getId().equals(id))
                .findFirst();
    }
}
