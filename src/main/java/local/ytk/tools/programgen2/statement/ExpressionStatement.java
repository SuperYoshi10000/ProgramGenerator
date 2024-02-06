package local.ytk.tools.programgen2.statement;

import local.ytk.tools.programgen2.expression.Expression;

public interface ExpressionStatement extends Statement {
    Expression expression();
}
