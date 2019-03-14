package com.refliction.reflictionweek2;

import lombok.Data;
import lombok.Value;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Scope("prototype")
@Component
public class Primes {


    public Boolean isPrime(Integer number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(e -> number % e == 0);
    }
}
