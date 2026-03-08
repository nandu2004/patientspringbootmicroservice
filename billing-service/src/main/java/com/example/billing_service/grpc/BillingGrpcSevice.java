package com.example.billing_service.grpc;

import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcSevice extends BillingServiceImplBase {
    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
            StreamObserver<billing.BillingResponse> responseObserver) {

    }

}
