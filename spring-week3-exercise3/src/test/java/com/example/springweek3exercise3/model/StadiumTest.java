package com.example.springweek3exercise3.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StadiumTest {
    @Autowired
Stadium stadium;
    @Test
    void getTeams() {
        int size = stadium.getTeams().size();
        System.out.println(stadium.getTeams());
        Assertions.assertEquals(5,size);

    }
}