package local.ytk.tools.programgen2.parts.declarations;

import local.ytk.tools.programgen2.expression.Expression;

public interface VariableDefinition extends Definition, VariableDeclaration {
    Expression expression();
}
