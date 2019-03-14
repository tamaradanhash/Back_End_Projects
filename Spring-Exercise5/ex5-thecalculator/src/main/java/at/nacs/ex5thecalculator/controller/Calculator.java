package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operations.*;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Set;

@Component
@RequiredArgsConstructor
public class Calculator {
    private final Set<Operation> operations;

    public Double calculate(Expression expression) {
        return operations.stream()
                .filter(operation -> operation.matches(expression))
                .map(operation -> operation.apply(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
