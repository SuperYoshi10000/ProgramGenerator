package local.ytk.tools.programgen2.parts.literal;

import local.ytk.tools.programgen2.expression.Expression;
import local.ytk.tools.programgen2.parts.group.Either;

public interface TemplateLiteral extends DynamicLiteral {
    Either.List<StringLiteral, Expression> parts();
}
