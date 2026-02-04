package com.pashi44.billingservice.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pashi44.billing.BillingRequest;
import com.pashi44.billing.BillingResponse;
import com.pashi44.billing.BillingServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

//register  this Grpc Service with spring
@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    // Implement gRPC service methods here

    private Logger logger = LoggerFactory.getLogger(BillingGrpcService.class);

    //overrideing the abstarct method defiend from teh grpc proto service func siganture
    @Override

    public void createBillingAccount(BillingRequest request,
            StreamObserver<BillingResponse> responseObserver) {

        logger.info("Creating billing account for user: {}", request.toString());

        BillingResponse response = BillingResponse.newBuilder()
                .setStatus("SUCCESS")
                .setAccountId("3003")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
