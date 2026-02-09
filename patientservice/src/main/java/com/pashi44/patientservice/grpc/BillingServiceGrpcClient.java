package com.pashi44.patientservice.grpc;

import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    

    private final BillingServiceGrpcClient.BillingServiceBlockingStub billingServiceBlockingStub;
    public BillingServiceGrpcClient(BillingServiceGrpcClient.BillingServiceBlockingStub billingServiceBlockingStub) {
        this.billingServiceBlockingStub = billingServiceBlockingStub;
    }
}
