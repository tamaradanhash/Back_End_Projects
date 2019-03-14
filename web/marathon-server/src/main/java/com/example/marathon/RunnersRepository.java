package com.example.marathon;

import com.example.marathon.domain.Runner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RunnersRepository {
    private Set<Runner> runners = new HashSet<>();

    public void addRunner(Runner runner) {
        runners.add(runner);
    }

    public List<Runner> getAll() {
        return new ArrayList<>(runners);
    }

    public Optional<Runner> getFastestRunner() {
        return runners.stream()
                .min(Comparator.comparing(Runner::getTime));
    }
}
