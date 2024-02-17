package local.ytk.tools.programgen2.expression;

import java.util.Collection;

import local.ytk.tools.programgen2.parts.ProgramPart;

public interface ExpressionList extends ProgramPart {
    Collection<Expression> expressions();
}
