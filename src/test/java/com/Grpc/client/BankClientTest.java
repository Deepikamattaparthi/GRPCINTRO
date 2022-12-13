package com.Grpc.client;

import com.Grpc.models.Balance;
import com.Grpc.models.BalanceCheckRequest;
import com.Grpc.models.BankServiceGrpc;
import com.Grpc.server.BankService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;

        @BeforeAll
        public void setup(){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("LocalHost", 6565)
                .usePlaintext()
                .build();

        this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
    }

        @Test
        public void balanceTest(){
            BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                    .setAccountNumber(8)
                    .build();

            Balance balance = this.blockingStub.getBalance(balanceCheckRequest);
            System.out.println("Recevied: " + balance.getAmount() );
        }
}
