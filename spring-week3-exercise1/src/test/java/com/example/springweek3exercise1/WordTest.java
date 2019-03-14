package com.example.springweek3exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WordTest {
    @Autowired
Word word;
    @Test
    void getWord() {
        String expected="fantastic";
        String actual=word.getWord();
        Assertions.assertEquals(expected,actual);
    }
}