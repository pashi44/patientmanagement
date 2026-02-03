package com.pashi44.patientservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
Map<String,String> errs= new HashMap<>();


ex.getBindingResult().getFieldErrors().forEach(error -> {
    errs.put(error.getField(), error.getDefaultMessage());
});

return ResponseEntity.badRequest().body(errs);
}


@ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
    //logger
    logger.warn("Email already exists: {}", ex.getMessage());
    Map<String, String> error = new HashMap<>();
    error.put("error", ex.getMessage()+ " already exists ");
    return ResponseEntity.badRequest().body(error);
}


@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
    //logger
    logger.error("Resource not found: {}", ex.getMessage());
    Map<String, String> error = new HashMap<>();
    error.put("error", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
}


}