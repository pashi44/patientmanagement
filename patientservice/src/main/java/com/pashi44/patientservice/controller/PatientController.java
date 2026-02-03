package com.pashi44.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pashi44.patientservice.dto.PatientRequestDTO;
import com.pashi44.patientservice.dto.PatientResponseDTO;
import com.pashi44.patientservice.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")

public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")

    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok().body( patients);
    }



    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(
        @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO createdPatient = patientService.createPatient(patientRequestDTO);
        
   
        return ResponseEntity.ok().body(createdPatient);


    // return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }
}