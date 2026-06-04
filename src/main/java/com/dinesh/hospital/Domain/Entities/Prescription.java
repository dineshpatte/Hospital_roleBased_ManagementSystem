package com.dinesh.hospital.Domain.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String medicationName;
    private String dosage;
    private String instructions;

    private LocalDate issuedDate;
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
