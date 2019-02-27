package com.refliction.reflictionweek2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrimesTest {

    @Autowired
    Primes primes;
    @Test
    void isPrime() {
        assertTrue(primes.isPrime(7));
    }
    void isNotPrime(){
        assertFalse(primes.isPrime(4));
    }


    @ParameterizedTest
    @CsvSource({
            "true,3",
           "false, 26",
           "false, 49",
           "true, 11",
           "false,0",

    })
    void matche(boolean expected, int number) {


        boolean result =primes.isPrime(number);

        assertEquals(expected, result);
    }
}
