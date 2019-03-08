package com.example.springweek3exercise1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SaunaTest {
    @Autowired
    SaunaLoader loader;

    @Test
    void getAvailableseats() {

        Sauna sauna = loader.getSauna();
        int availableseats = sauna.getAvailableseats();
        assertEquals(2, availableseats);
    }

    @Test
    void getTemerature() {
        Sauna sauna = loader.getSauna();
        int temerature = sauna.getTemerature();
        assertEquals(45, temerature);
    }
}