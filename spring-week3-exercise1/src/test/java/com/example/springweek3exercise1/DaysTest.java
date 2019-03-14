package com.example.springweek3exercise1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DaysTest {
    @Autowired
    Days days;

    @ParameterizedTest
    @ValueSource(strings = {"Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"})
    void getDays(String day) {
        List<String> days = this.days.getDays();
        assertTrue(days.contains(day));
    }

    @ParameterizedTest
    @CsvSource({"0,Saturday",
            "1,Sunday",
            "2,Monday",
            "3,Tuesday",
            "4,Wednesday",
            "5,Thursday",
            "6,Friday"})
    void checkOrder(int position, String day) {
        List<String> days = this.days.getDays();

        assertEquals(day, days.get(position));

//       assertTrue(days.contains(day));


    }
}