package local.ytk.tools.programgen2.expression.operator;

import local.ytk.tools.programgen2.type.Type;

public interface BinaryOperator extends Operator {
    Type expr1type();
    Type expr2type();    
}
