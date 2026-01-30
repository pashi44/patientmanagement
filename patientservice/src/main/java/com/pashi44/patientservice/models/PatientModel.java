package com.pashi44.patientservice.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;
@NotNull
private String address;

@NotNull
private LocalDate dateOfBirth;
@NotNull
private LocalDate registrationDate;


    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public  @NotNull  @Email String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail( @NotNull @Email String email) {
        this.email = email;
    }

    /**
     * @return String return the address
     */
    public  @NotNull String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress( @NotNull  String address) {
        this.address = address;
    }

    /**
     * @return LocalDate return the dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return LocalDate return the registrationDate
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

}
