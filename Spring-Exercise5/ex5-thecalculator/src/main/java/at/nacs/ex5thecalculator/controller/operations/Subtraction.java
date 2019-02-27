package at.nacs.ex5thecalculator.controller.operations;

import at.nacs.ex5thecalculator.model.Expression;
import lombok.Value;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
@Value
@Component
public class Subtraction implements Operation {
    @Override
    public boolean matches(Expression expression) {
        return expression.getSymbol().equals("-");
    }

    @Override
    public Double apply(Expression expression) {
        return expression.getNumber1()-expression.getNumber2();
    }
}
