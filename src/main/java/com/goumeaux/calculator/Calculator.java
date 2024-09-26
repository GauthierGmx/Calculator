package com.goumeaux.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    // MÉTHODES
    public static int add(int opG, int opD) {
        if ((opG > 0 && opD > Integer.MAX_VALUE - opG) || (opD > 0 && opG > Integer.MAX_VALUE - opD)) {
            throw new RuntimeException("Dépassement de la limite du Int");
        }
        else if ((opG < 0 && opD < Integer.MIN_VALUE - opG) || (opD < 0 && opG < Integer.MIN_VALUE - opD)) {
            throw new RuntimeException("Dépassement de la limite du Int");
        }
        else {
            return opG + opD;
        }
    };

    public static int divide(int opG, int opD) {
        if (opD != 0) {
            return opG / opD;
        }
        else {
            throw new RuntimeException("Division par 0 impossible");
        }
    };

    public static Set<Integer> ensembleChiffres(int pNombre) {
        Set<Integer> listeChiffre = new HashSet<Integer>();
        String nombreStr = String.valueOf(Math.abs(pNombre));

        for (int i = 0; i < nombreStr.length(); i++) {
            char c = nombreStr.charAt(i);
            listeChiffre.add(Character.getNumericValue(c));
        }
        return listeChiffre;
    };
}

