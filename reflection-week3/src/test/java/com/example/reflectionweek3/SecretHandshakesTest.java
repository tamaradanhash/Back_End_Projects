package com.example.reflectionweek3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecretHandshakesTest {
    @Autowired
    SecretHandshakes shakes;
    @Test
    void getSecrethandshakes() {
shakes.getSecrethandshakes().entrySet().stream()
        .map(handshake-> handshake.getKey()+handshake.getValue())
        .forEach(e -> System.out.println(e));
    }
}