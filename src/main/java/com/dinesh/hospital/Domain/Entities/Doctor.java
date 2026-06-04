package com.dinesh.hospital.Domain.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
   private User user;

    private String specialization;

    @Column(unique = true)
    private String licenceNumber;

    private String Phone;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private String department;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Appointment> appointments =  new ArrayList<Appointment>();

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<MedicalRecord> medicalRecords = new ArrayList<>();


}
