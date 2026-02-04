package com.pashi44.billingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BillingserviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext billingservicemain = SpringApplication.run(BillingserviceApplication.class, args);

    }

}
