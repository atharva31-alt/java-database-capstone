package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Criterion 1: Accepts an email address as input and returns an Optional
    Optional<Patient> findByEmail(String email);
    
    // Criterion 2: Enhancements allowing dual flexible retrieval based on either email OR phone number
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
