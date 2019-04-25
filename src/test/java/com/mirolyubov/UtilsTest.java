package com.mirolyubov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Utils utils;

    @BeforeEach
    void setUp() {
        utils = new Utils();
    }

    @AfterEach
    void tearDown() {
        utils = null;
    }

    @Test
    void concatenateWordsRightWay() {
        assertEquals("first second", utils.concatenateWords("first ", "second"));
    }

    @Test
    void concatenateWordsRightWayLineBreaker() {
        assertEquals("first\nsecond", utils.concatenateWords("first\n", "second"));
    }

    @Test
    void concatenateWordsEmptyString() {
        assertEquals("", utils.concatenateWords("", ""));
    }

    @Test
    void concatenateWordsNullStrings() {
        assertThrows(NullPointerException.class,
                ()-> utils.concatenateWords(null, "secondStroke"));
    }

    @Test
    void concatenateWordsNullStrings2() {
        assertThrows(NullPointerException.class,
                ()-> utils.concatenateWords("firstStroke", null));
    }

    @Test
    void concatenateWordsNullStrings3() {
        assertThrows(NullPointerException.class,
                ()-> utils.concatenateWords(null, null));
    }

    @Test
    void concatenateWordsLatin() {
        assertEquals("latin latin", utils.concatenateWords("latin ", "latin"));
    }

    @Test
    void concatenateWordsNotLatin() {
        assertEquals("latin не латин", utils.concatenateWords("latin ", "не латин"));
    }

    @Test
    void concatenateWordsNotLatinWithSymbols() {
        assertEquals("latin 322", utils.concatenateWords("latin ", "322"));
    }

    @Disabled
    @Test
    void computeFactorial() {
        assertEquals(BigInteger.valueOf(6), utils.computeFactorial(3));
    }

    @Test
    void testFactorialWithTimeout() {
        assertTimeout(Duration.ofMillis(1), () -> {
            utils.computeFactorial(200);
        });
    }

    @Test
    void computeFactorialZero() {
        assertEquals(BigInteger.valueOf(1), utils.computeFactorial(0));
    }
}