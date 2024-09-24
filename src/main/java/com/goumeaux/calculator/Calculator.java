package com.goumeaux.calculator;

public class Calculator {
    public int add(int opG, int opD) {
        return opG + opD;
    };
    public int divide(int opG, int opD) {
        if (opD != 0) {
            return opG / opD;
        }
        else {
            throw new RuntimeException("Division par 0 impossible");
        }
    };
}

