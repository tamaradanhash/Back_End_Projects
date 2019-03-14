package at.nacs.ex5thecalculator.controller.operations;

import at.nacs.ex5thecalculator.model.Expression;

public interface Operation {
    boolean matches(Expression expression);

    Double apply(Expression expression);
}
