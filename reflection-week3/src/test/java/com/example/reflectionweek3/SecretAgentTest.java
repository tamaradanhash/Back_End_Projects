package com.example.reflectionweek3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AgentTest {
@Autowired
Agent agent;
    @Test
    void translateToSecretHandShake() {
        List<String> secretHandShake = agent.translateToSecretHandShake(135);
        System.out.println(secretHandShake);
    }
}