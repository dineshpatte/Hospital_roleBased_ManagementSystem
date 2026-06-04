package com.dinesh.hospital.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private UUID patientId;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private String phone;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private String address;

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments =  new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Prescription> prescriptions =  new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<MedicalRecord> medicalRecords =  new ArrayList<>();
}
