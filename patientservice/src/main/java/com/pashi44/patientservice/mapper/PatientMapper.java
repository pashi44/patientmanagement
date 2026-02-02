package com.pashi44.patientservice.mapper;

import com.pashi44.patientservice.dto.PatientResponseDTO;
import com.pashi44.patientservice.models.PatientModel;

public class PatientMapper {

    public static PatientResponseDTO toDTO(PatientModel patient) {
        PatientResponseDTO patientdto = new PatientResponseDTO();
        patientdto.setId(String.valueOf(patient.getId()));
        patientdto.setName(patient.getName());
        patientdto.setEmail(patient.getEmail());
        patientdto.setAddress(patient.getAddress());
        patientdto.setDateofbirth(patient.getDateOfBirth().toString());
        return patientdto;
    }

    public static PatientModel toEntity(PatientResponseDTO dto) {
        PatientModel patient = new PatientModel();
        patient.setId(Long.parseLong(dto.getId()));
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        // patient.setDateofbirth(dto.getDateofbirth());
        return patient;
    }

}
