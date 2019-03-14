package com.example.springweek3exercise1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MagicNumberTest {
@Autowired
    MagicNumber magicNumber;
    @Test
    void getMagicNumber() {
        Integer expected=369;
        Integer actual=magicNumber.getMagicNumber();
        assertEquals(expected,actual);
    }
}