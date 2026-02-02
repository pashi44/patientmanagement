package com.pashi44.patientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pashi44.patientservice.dto.PatientResponseDTO;
import com.pashi44.patientservice.mapper.PatientMapper;
import com.pashi44.patientservice.models.PatientModel;
import com.pashi44.patientservice.repository.IPatientRepository;

@Service
public class PatientService  {

    
    private final IPatientRepository patientRepository;
@Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



public List<PatientResponseDTO>  getAllPatients() {
    
    List<PatientModel> patients =  patientRepository.findAll();


List<PatientResponseDTO>  patientResponseDTOs= 
 patients.stream().map(patient -> PatientMapper.toDTO(patient))
       .toList();
 
      return patientResponseDTOs;

}



}