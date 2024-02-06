package local.ytk.tools.programgen2.expression;

import local.ytk.tools.programgen2.expression.operator.Operator;

public interface OperatorExpression extends Expression {
    Operator operator();
}
