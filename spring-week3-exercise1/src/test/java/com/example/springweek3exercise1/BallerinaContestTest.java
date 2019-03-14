package com.example.springweek3exercise1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BallerinaContestTest {
    @Autowired
BallerinaContest contest;
    @Test
    void getBallerinas() {
        int numberOfBallerinas = contest.getBallerinas().size();
        assertEquals(3,numberOfBallerinas);
    }

    @ParameterizedTest
    @CsvSource({"0,Tamara,5",
            "1,Diba,3.9",
            "2,Mahtab,4.2"})
    void checkBallerinas(int position,String name,double quality){

        List<Ballerina> ballerinas = contest.getBallerinas();
        Ballerina ballerina = ballerinas.get(position);
        assertEquals(name,ballerina.getName());
        assertEquals(quality,ballerina.getPerformancequality());
    }
}