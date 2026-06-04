package com.dinesh.hospital.Domain.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "medical-records")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private String diagnosis;
    private String treatment;
    private String notes;

    @CreationTimestamp
    private LocalDateTime recordDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
