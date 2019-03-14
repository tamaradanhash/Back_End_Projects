package com.example.reflectionweek3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SecretAgent {
    private final SecretHandshakes handshakes;
    private final Digits digits;

    public List<String> translateToSecretHandShake(Integer price) {
        Map<Integer, String> secrethandshakes = handshakes.getSecrethandshakes();

        List<Integer> priceDigits = digits.getDigits(price);
        return priceDigits.stream().filter(secrethandshakes::containsKey).map(secrethandshakes::get).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
