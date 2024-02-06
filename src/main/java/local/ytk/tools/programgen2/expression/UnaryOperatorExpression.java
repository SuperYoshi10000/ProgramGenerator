package local.ytk.tools.programgen2.expression;

import local.ytk.tools.programgen2.expression.operator.UnaryOperator;

public interface UnaryOperatorExpression extends OperatorExpression {
    @Override
    UnaryOperator operator();
    Expression expr();
}
