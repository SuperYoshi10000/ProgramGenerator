package local.ytk.tools.programgen2.expression;

import local.ytk.tools.programgen2.expression.operator.TernaryOperator;

public interface TernaryOperatorExpression extends OperatorExpression {
    @Override
    TernaryOperator operator();
    Expression expr1();
    Expression expr2();
    Expression expr3();
}
