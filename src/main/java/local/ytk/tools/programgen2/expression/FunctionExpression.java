package local.ytk.tools.programgen2.expression;

import local.ytk.tools.programgen2.statement.FunctionCall;

public interface FunctionExpression extends Expression {
    FunctionCall functionCall();
}
