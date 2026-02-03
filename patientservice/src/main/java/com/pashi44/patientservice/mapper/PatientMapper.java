package com.pashi44.patientservice.mapper;

import com.pashi44.patientservice.dto.PatientRequestDTO;
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

    public static PatientModel toEntity(PatientRequestDTO patientRequestDTO) {

PatientModel patientModel = new PatientModel();
        patientModel.setName(patientRequestDTO.getName());
        patientModel.setEmail(patientRequestDTO.getEmail());
        patientModel.setAddress(patientRequestDTO.getAddress());
        patientModel.setDateOfBirth(java.time.LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patientModel.setRegistrationDate(java.time.LocalDate.now());
        return patientModel;



    }

  
}
