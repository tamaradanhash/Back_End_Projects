package com.example.reflectionweek3;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Agent {
    private final SecretHandshakes handshakes;
    private final Digits digits;

    public List<String> translateToSecretHandShake(Integer price) {
        Map<Integer, String> secrethandshakes = handshakes.getSecrethandshakes();

        List<Integer> priceDigits = digits.getDigits(price);
        return priceDigits.stream().filter(secrethandshakes::containsKey).map(secrethandshakes::get).filter(Objects::nonNull).collect(Collectors.toList());
        //return priceDigits.stream().map(e -> pickTheRightHandshake(e)).filter(Objects::nonNull).collect(Collectors.toList());

    }

//    private String pickTheRightHandshake(Integer digit) {
//        Map<Integer, String> secrethandshakes = handshakes.getSecrethandshakes();
//
//        if (secrethandshakes.containsKey(digit)) {
//            return secrethandshakes.get(digit);
//
//        }
//        return "";
//    }

}
