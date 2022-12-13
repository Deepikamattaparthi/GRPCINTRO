package com.Grpc.server;

import com.Grpc.models.Balance;
import com.Grpc.models.BalanceCheckRequest;
import com.Grpc.models.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {

      int accountNumber = request.getAccountNumber();
      Balance balance =  Balance.newBuilder()
                .setAmount(AccountDataBase.getBalance(accountNumber))
                .build();

      responseObserver.onNext(balance);
      responseObserver.onCompleted();

    }
}
