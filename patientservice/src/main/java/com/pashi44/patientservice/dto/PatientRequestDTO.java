package com.pashi44.patientservice.dto;

import com.pashi44.patientservice.dto.validators.CreatePatientValidationGroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message = "Name is mandatory")
    @NotNull(message="Name shouldn't  be  null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @NotEmpty(message = "Email must not be empty")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 200, message = "Address must be less than 200 characters")
    private String address;

    @NotBlank(message = "Date of Birth is mandatory")
    @Size(max = 10, message = "Date of Birth must be in the format YYYY-MM-DD")
    private String dateOfBirth;

    //the groups tells to find the exception  fields for this registration field
    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registration Date is mandatory")
    @Size(max = 10, message = "Registration Date must be in the format YYYY-MM-DD")
    private String registrationDate;


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
