package local.ytk.tools.programgen2._impl;

import java.util.Collection;
import java.util.List;

import local.ytk.tools.programgen2.expression.Expression;
import local.ytk.tools.programgen2.lang.Language;
import local.ytk.tools.programgen2.parts.declarations.PropertyDeclaration;
import local.ytk.tools.programgen2.parts.literal.ArrayLiteral;
import local.ytk.tools.programgen2.parts.literal.BooleanLiteral;
import local.ytk.tools.programgen2.parts.literal.CharacterLiteral;
import local.ytk.tools.programgen2.parts.literal.ClassLiteral;
import local.ytk.tools.programgen2.parts.literal.ConstantLiteral;
import local.ytk.tools.programgen2.parts.literal.DynamicLiteral;
import local.ytk.tools.programgen2.parts.literal.FunctionLiteral;
import local.ytk.tools.programgen2.parts.literal.Literal;
import local.ytk.tools.programgen2.parts.literal.NullLiteral;
import local.ytk.tools.programgen2.parts.literal.NumberLiteral;
import local.ytk.tools.programgen2.parts.literal.ObjectLiteral;
import local.ytk.tools.programgen2.parts.literal.StringLiteral;
import local.ytk.tools.programgen2.parts.literal.TemplateLiteral;
import local.ytk.tools.programgen2.type.BooleanType;
import local.ytk.tools.programgen2.type.CharacterType;
import local.ytk.tools.programgen2.type.NullType;
import local.ytk.tools.programgen2.type.NumericType;
import local.ytk.tools.programgen2.type.StringType;
import local.ytk.tools.programgen2.type.Type;
import local.ytk.tools.programgen2.value.StringValue;

public class Literals implements Language.Literals {
    public Literals(Language.Types types) {
        super();
        this.types = types;
    }
    final Language.Types types;

    @Override
    public Literal literal() {
        throw new UnsupportedOperationException("Unimplemented method 'literal'");
    }

    @Override
    public ConstantLiteral constant() {
        throw new UnsupportedOperationException("Unimplemented method 'constant'");
    }

    @Override
    public ArrayLiteral array(List<Expression> expressions) {
        String s = String.join(", ", expressions.stream().map(Expression::generate).toArray(String[]::new));
        return new ArrayLiteral() {
            @Override
            public String generate() {
                return "new Object[]{" + s + "}";
            }
            @Override
            public String generate(Type type) {
                return "new " + type.generate() + "[]{" + s + "}";
            }

            @Override
            public Collection<Expression> expressions() {
                return expressions;
            }
        };
    }

    @Override
    public BooleanLiteral bool(boolean b) {
        String s = Boolean.toString(b);
        return new BooleanLiteral() {
            @Override
            public BooleanType type() {
                return types.bool();
            }
            @Override
            public String generate() {
                return s;
            }
        };
    }

    @Override
    public CharacterLiteral character(char c) {
        String s = Character.toString(c);
        return new CharacterLiteral() {
            @Override
            public CharacterType type() {
                return types.character();
            }
            @Override
            public String generate() {
                return s;
            }
        };
    }

    @Override
    public NullLiteral nullLiteral() {
        return new NullLiteral() {
            @Override
            public NullType type() {
                return types.nullType();
            }
            @Override
            public String generate() {
                return "null";
            }
        };
    }

    @Override
    public NumberLiteral number(Number number) {
        String s;
        if (number instanceof Byte) s = "(byte) " + Byte.toString(number.byteValue());
        else if (number instanceof Short) s = "(short) " + Short.toString(number.byteValue());
        else if (number instanceof Integer) s = Integer.toString(number.intValue());
        else if (number instanceof Long) s = Long.toString(number.longValue()) + "l";
        else if (number instanceof Float) s = Float.toString(number.floatValue()) + "f";
        else s = Double.toString(number.doubleValue()) + "d";
        return new NumberLiteral() {
            @Override
            public NumericType type() {
                return types.numeric();
            }
            @Override
            public String generate() {
                return s;
            }
        };
    }

    @Override
    public ObjectLiteral object(List<PropertyDeclaration> properties) {
        throw new UnsupportedOperationException("This language does not support object literals");
    }

    @Override
    public StringLiteral string(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(switch(c) {
                case '\0', '\1', '\2', '\3', '\4', '\5', '\6', '\7', '\b', '\t', '\n', '\f', '\r', '\"', '\'', '\\' -> "\\" + c;
                default -> c > 31 && c < 127 ? Character.toString(c) : "\\u000" + "%04x".formatted((int)c);
            });
        }
        String o = str;
        String s = "\"" + sb.toString() + "\"";
        return new StringLiteral() {
            @Override
            public StringType type() {
                return types.string();
            }
            @Override
            public String generate() {
                return s;
            }
            @Override
            public StringValue value() {
                return new StringValue() {
                    @Override
                    public StringType type() {
                        return types.string();
                    }
                    @Override
                    public String str() {
                        return o;
                    }
                };
            }
        };
    }

    @Override
    public DynamicLiteral dynamic() {
        throw new UnsupportedOperationException("Unimplemented method 'dynamic'");
    }

    @Override
    public TemplateLiteral template() {
        throw new UnsupportedOperationException("This language does not support template literals");
    }

    @Override
    public ClassLiteral classLiteral() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'classLiteral'");
    }

    @Override
    public FunctionLiteral function() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'function'");
    }
    
}
