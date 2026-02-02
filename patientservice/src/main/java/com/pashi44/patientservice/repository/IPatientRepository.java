package com.pashi44.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pashi44.patientservice.models.PatientModel;
@Repository
public interface IPatientRepository extends JpaRepository<PatientModel, Long> {

}
