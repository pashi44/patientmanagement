package com.pashi44.patientservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pashi44.patientservice.dto.PatientRequestDTO;
import com.pashi44.patientservice.dto.PatientResponseDTO;
import com.pashi44.patientservice.exceptions.EmailAlreadyExistsException;
import com.pashi44.patientservice.exceptions.ResourceNotFoundException;
import com.pashi44.patientservice.mapper.PatientMapper;
import com.pashi44.patientservice.models.PatientModel;
import com.pashi44.patientservice.repository.IPatientRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@Service
public class PatientService {

    private final IPatientRepository patientRepository;

    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // get all
    public List<PatientResponseDTO> getAllPatients() {

        List<PatientModel> patients = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDTO(patient))
                .toList();

        return patientResponseDTOs;

    }

    // post patient
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDTO.getEmail());
        }
        PatientModel newpatient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));
        return PatientMapper.toDTO(newpatient);

    }
    public PatientResponseDTO updatePatient(
        
        
        Long id, PatientRequestDTO patientRequestDTO) {

            if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDTO.getEmail());
        }
PatientModel pat = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        pat.setName(patientRequestDTO.getName());
        pat.setEmail(patientRequestDTO.getEmail());
        pat.setAddress(patientRequestDTO.getAddress());
        pat.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        PatientModel updatedPatient = patientRepository.save(pat);
        return PatientMapper.toDTO(updatedPatient);

}
}

