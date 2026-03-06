package com.example.patient_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patient_service.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Boolean existsByEmail(String email);

    Boolean existsByEmailAndIdNot(String email, UUID id);

}
