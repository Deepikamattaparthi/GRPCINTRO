package com.Grpc.server;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountDataBase {
    /*
    This is a Database
     1 => 10
     2 => 20
     ....
     10 => 100
     */

    private static final Map<Integer,Integer> MAP = IntStream.rangeClosed(2,10)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), v ->  v * 10));

    public static int getBalance(int accountId){
        return MAP.get(accountId);
    }

    public static Integer addBalance(int accountId, int amount){
       return  MAP.computeIfPresent(accountId, (k, v) -> v + amount);
    }

    public static Integer deductBalance(int accountId, int amount){
        return MAP.computeIfPresent(accountId, (k, v) -> v  - amount);

    }
}
