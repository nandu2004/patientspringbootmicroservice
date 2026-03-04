package com.example.patient_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponseDTO {

    private String id;
    private String email;
    private String name;
    private String dateOfBirth;
    private String address;
}