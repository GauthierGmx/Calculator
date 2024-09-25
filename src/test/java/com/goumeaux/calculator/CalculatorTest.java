package com.goumeaux.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

class CalculatorTest {
    int opG;
    int opD;

    @BeforeEach
    void set_up() {
        opG = 1;
        opD = 1;
    };

    @AfterEach
    void tear_down() {
        opG = 0;
        opD = 0;
    }

    /* ========================
        TEST DE LA METHODE ADD
       ======================== */
    @Test
    void add_devrait_calculer_la_somme_des_deux_operateurs() {
        // WHEN
        int resultat = Calculator.add(opG, opD);
        // THEN
        assertThat(resultat).isEqualTo(opG + opD);
    }

    @ParameterizedTest
    @CsvSource ({
            "0,1,1",
            "1,2,3",
            "-2,2,0",
            "0,0,0",
            "-1,-2,-3"
    })
    void add_devrait_calculer_la_somme_des_valeurs_parametrees(int opG, int opD, int resultatAttendu) {
        // WHEN
        int resultat = Calculator.add(opG, opD);
        // THEN
        assertThat(resultat).isEqualTo(resultatAttendu);
    }
    /* ===========================
        TEST DE LA METHODE DIVIDE
       =========================== */
    @Test
    void divide_devrait_calculer_la_division_des_deux_operateurs() {
         // WHEN
         int resultat = Calculator.divide(opG,opD);
         // THEN
         assertThat(resultat).isEqualTo(opG / opD);
    }

    @Test
    void divide_devrait_lever_une_erreur_en_cas_de_division_par_zero() {
        // WHEN
        Throwable uneErreur = Assertions.catchThrowable(()->Calculator.divide(opG,opD));
        // THEN
        assertThat(uneErreur).hasMessage("Division par 0 impossible");
    }

    /* ====================================
        TEST DE LA MÉTHODE ENSEMBLECHIFFRE
       ==================================== */
    @Test
    void ensembleChiffre_devrait_retourner_la_liste_des_chiffres_qui_compose_le_nombre() {
        // GIVEN
        int unNombre = -11;

        Set<Integer> chiffresAttendus = new HashSet<Integer>();
        String nombreStr = String.valueOf(Math.abs(unNombre));
        for (int i = 0; i < nombreStr.length(); i++) {
            chiffresAttendus.add(Character.getNumericValue(nombreStr.charAt(i)));
        }
        // WHEN
        Set<Integer> resultat = Calculator.ensembleChiffres(unNombre);
        // THEN
        assertThat(resultat).containsExactlyInAnyOrderElementsOf(chiffresAttendus);
    }
}