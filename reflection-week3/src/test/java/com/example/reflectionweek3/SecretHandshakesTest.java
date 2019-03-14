package com.example.reflectionweek3;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SecretHandshakesTest {
    @Autowired
    SecretHandshakes shakes;

    @Test
    void getSecrethandshakes() {
        int size = shakes.getSecrethandshakes().size();
        Assertions.assertEquals(5,size);
    }
    @ParameterizedTest
    @CsvSource({"2,thumb touches back",
    "3,little finger grab",
    "5,tickles over palm",
    "6,bro knock",
    "9,thousand knuckles"})
    void testKeyAndValue(Integer key,String value){
        assertTrue(shakes.getSecrethandshakes().containsKey(key) && shakes.getSecrethandshakes().containsValue(value));
        assertThat(shakes.getSecrethandshakes(), IsMapContaining.hasEntry(key, value));

    }
}

