package local.ytk.tools.programgen2.expression;

import local.ytk.tools.programgen2.expression.operator.BinaryOperator;

public interface BinaryOperatorExpression extends OperatorExpression {
    @Override
    BinaryOperator operator();
    Expression expr1();
    Expression expr2();
}