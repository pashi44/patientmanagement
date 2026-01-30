package com.pashi44.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PatientserviceApplication {

	public static void main(String[] args) {
   ConfigurableApplicationContext psmain = 
   SpringApplication.run(PatientserviceApplication.class, args);
	}

}
