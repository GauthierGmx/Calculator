package com.goumeaux.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

class CalculatorTest {
    @BeforeEach
    void set_up() {
        int opG = 1;
        int opD = 1;
    };

    @AfterEach
    void tear_down() {
        int opG = 0;
        int opD = 0;
    }

    @Test
    void add_devrait_calculer_la_somme_des_deux_operateurs() {
        // GIVEN
        int opG = 1;
        int opD = 1;
        // WHEN
        int resultat = Calculator.add(opG, opD);
        // THEN
        assertThat(resultat).isEqualTo(opG + opD);
    }

    @Test
    void divide_devrait_calculer_la_division_des_deux_operateurs() {
         // GIVEN
         int opG = 1;
         int opD = 1;
         // WHEN
         int resultat = Calculator.divide(opG,opD);
         // THEN
         assertThat(resultat).isEqualTo(opG / opD);
    }

    @Test
    void divide_devrait_lever_une_erreur_en_cas_de_division_par_zero() {
        // GIVEN
        int opG = 1;
        int opD = 0;
        // WHEN
        Throwable uneErreur = Assertions.catchThrowable(()->Calculator.divide(opG,opD));
        // THEN
        assertThat(uneErreur).hasMessage("Division par 0 impossible");
    }
}