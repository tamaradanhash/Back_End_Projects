package at.nacs.ex5thecalculator.controller.operations;

import at.nacs.ex5thecalculator.model.Expression;
import org.springframework.stereotype.Component;

@Component
public class Multiplication implements Operation {
    @Override
    public boolean matches(Expression expression) {
        return expression.getSymbol().equals("*");
    }

    @Override
    public Double apply(Expression expression) {
        return expression.getNumber1() * expression.getNumber2();
    }
}
