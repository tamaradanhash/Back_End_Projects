package com.example.reflectionweek3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DigitsTest {
@Autowired
 Digits digits;
    @ParameterizedTest
    @MethodSource("generateData")
    void testDigitsList(Integer number, List<Integer> expected) {

        List<Integer> actual = this.digits.getDigits(number);
        assertEquals(actual,expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(19559, Arrays.asList(1,9,5,5,9)),
                Arguments.of(324, Arrays.asList(3,2,4)),
                Arguments.of(1934, Arrays.asList(1,9,3,4))
        );
    }
}