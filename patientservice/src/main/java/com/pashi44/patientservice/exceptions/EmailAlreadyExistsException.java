package com.pashi44.patientservice.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

}
