package com.mirolyubov;

import java.math.BigInteger;

public class Utils {

    public String concatenateWords(String firstStroke, String secondStroke) {
        return new StringBuilder(firstStroke).append(new StringBuilder(secondStroke)).toString();
    }

    public BigInteger computeFactorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
