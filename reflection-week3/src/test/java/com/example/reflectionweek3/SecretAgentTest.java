package com.example.reflectionweek3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecretAgentTest {
@Autowired
SecretAgent agent;
    @Test
    void translateToSecretHandShake() {
        List<String> secretHandShake = agent.translateToSecretHandShake(135);

    }
    @ParameterizedTest
    @MethodSource("generateData")
    void testGetTheSecretHandshakes(Integer number, List<String> expected) {

        List<String> actual = agent.translateToSecretHandShake(number);
        assertEquals(actual,expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(19559, Arrays.asList("thousand knuckles", "tickles over palm","tickles over palm","thousand knuckles")),
                Arguments.of(324, Arrays.asList("little finger grab", "thumb touches back")),
                Arguments.of(1934, Arrays.asList("thousand knuckles","little finger grab")),
                Arguments.of(111111, Arrays.asList())
        );
    }
}