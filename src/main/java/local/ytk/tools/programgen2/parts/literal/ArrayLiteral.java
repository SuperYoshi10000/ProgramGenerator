package local.ytk.tools.programgen2.parts.literal;

import local.ytk.tools.programgen2.expression.ExpressionList;
import local.ytk.tools.programgen2.type.Type;

public interface ArrayLiteral extends DynamicLiteral, ExpressionList {
    String generate(Type type);
}
