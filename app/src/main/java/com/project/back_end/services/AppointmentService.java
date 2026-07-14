package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final List<Appointment> appointmentDatabase = new ArrayList<>();

    public Appointment scheduleAppointment(Appointment appointment) {
        // Business logic layer coordination placeholder
        appointmentDatabase.add(appointment);
        return appointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDatabase;
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentDatabase.stream()
                .filter(a -> a.getDoctor() != null && a.getDoctor().getId().equals(doctorId))
                .collect(Collectors.toList());
    }
}
