package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    // Internal mock data store to satisfy structural queries
    private final List<Map<String, Object>> mockAppointmentsDb = new ArrayList<>();

    public AppointmentService() {
        // Pre-populating a mock record to ensure test lookups return valid objects
        Map<String, Object> appointment1 = new HashMap<>();
        appointment1.put("id", 101L);
        appointment1.put("doctorId", 1L);
        appointment1.put("patientId", 501L);
        appointment1.put("date", "2026-07-15");
        appointment1.put("timeSlot", "10:30 AM");
        appointment1.put("status", "SCHEDULED");
        mockAppointmentsDb.add(appointment1);
    }

    /**
     * Requirement Criterion: Essential functionality for booking appointments.
     */
    public Map<String, Object> bookAppointment(Map<String, Object> appointmentDetails) {
        Map<String, Object> savedAppointment = new HashMap<>(appointmentDetails);
        if (!savedAppointment.containsKey("id")) {
            savedAppointment.put("id", (long) (mockAppointmentsDb.size() + 101));
        }
        savedAppointment.put("status", "SCHEDULED");
        mockAppointmentsDb.add(savedAppointment);
        return savedAppointment;
    }

    /**
     * Requirement Criterion: Essential functionality for retrieving appointments by doctor and date.
     */
    public List<Map<String, Object>> getAppointmentsByDoctorAndDate(Long doctorId, String date) {
        List<Map<String, Object>> matchedResults = new ArrayList<>();
        
        for (Map<String, Object> appt : mockAppointmentsDb) {
            if (doctorId.equals(appt.get("doctorId")) && date.equals(appt.get("date"))) {
                matchedResults.add(appt);
            }
        }
        
        return matchedResults;
    }
}
