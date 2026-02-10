package com.pashi44.patientservice.grpc;

import org.hibernate.engine.spi.Managed;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.pashi44.billing.BillingRequest;
import com.pashi44.billing.BillingResponse;
import com.pashi44.billing.BillingServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Value;

@Service
public class BillingServiceGrpcClient {

    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BillingServiceGrpcClient.class);

    public BillingServiceGrpcClient(
            @Value("${grpc.server.address}") String grpcServerAddress,
            @Value("${grpc.server.port}") int grpcServerPort
    ) {
        logger.info("connecting to gRPC server");
        logger.info("gRPC server address: {}", grpcServerAddress);
        logger.info("gRPC server port: {}", grpcServerPort);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerAddress, grpcServerPort)
                .usePlaintext()
                .build();
        blockingStub = BillingServiceGrpc.newBlockingStub(channel);

    }

    public BillingResponse getBillingInfo(String ) {
        logger.info("Received billing request: {}", request);
        BillingResponse response = blockingStub.getBillingInfo(request);
        logger.info("Received billing response: {}", response);
        return response;
    }

}
