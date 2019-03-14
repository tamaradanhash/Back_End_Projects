package com.refliction.reflictionweek2;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Scope("prototype")
@Component
@RequiredArgsConstructor
public class PrimesAdder {

    private final Primes primes;

    public int accumulatePrimes() {
        return IntStream.iterate(0, i -> i + 1)
                .filter(e -> primes.isPrime(e))
                .limit(100)
                .reduce(0, (x, y) -> x + y);
    }
}
