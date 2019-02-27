package com.refliction.reflictionweek2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PrimesAdderTest {
@Autowired
PrimesAdder primesAdder;
    @Test
    void accumulatePrimes() {
        assertEquals(24133,primesAdder.accumulatePrimes());
    }
}