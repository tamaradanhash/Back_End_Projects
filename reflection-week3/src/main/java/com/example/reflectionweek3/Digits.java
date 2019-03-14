package com.example.reflectionweek3;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Digits {
    public List<Integer> getDigits(Integer price) {
        return Stream.of(String.valueOf(price).split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }
}
