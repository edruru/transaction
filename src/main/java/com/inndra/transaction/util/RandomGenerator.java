package com.inndra.transaction.util;

import java.util.Random;
import java.util.UUID;

public class RandomGenerator {

    public static Long generateRandomNumber(long min, long max){
        return new Random().longs(min, max).limit(1).findFirst().getAsLong();
    }

    public static String generateRandomNumberByUUID() {
        return UUID.randomUUID().toString();
    }
}
