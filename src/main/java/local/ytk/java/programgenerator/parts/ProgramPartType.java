package local.ytk.java.programgenerator.parts;

import java.util.Arrays;
import java.util.stream.Stream;

public class ProgramPartType<T extends ProgramPartType<?>> {
    public final String name;
    public final ProgramPartType<?>[] subtypes;
    public final boolean optional;
    public final boolean exists;
    public final boolean multiple;
    public final ProgramPartType<?> other;

    protected ProgramPartType() {
        this(null);
    }
    protected ProgramPartType(String name) {
        this(name, false, VOID);
    }
    protected ProgramPartType(String name, ProgramPartType<?>... type) {
        this(name, false, false, type);
    }
    protected ProgramPartType(String name, boolean optional, ProgramPartType<?>... type) {
        this(name, optional, false, NONE, type);
    }
    protected ProgramPartType(String name, boolean optional, boolean multiple, ProgramPartType<?>... type) {
        this(name, optional, multiple, NONE, type);
    }
    protected ProgramPartType(String name, boolean optional, boolean multiple, ProgramPartType<?> other, ProgramPartType<?>[] type) {
        this.name = name;
        this.optional = optional;
        this.multiple = multiple;
        this.other = other;
        this.subtypes = type;
        this.exists = true;
    }

    public static final Keyword KEYWORD = new Keyword("Keyword");
    public static final Type TYPE = new Type("Type");
    public static final Name NAME = new Name("Name");
    public static final Value VALUE = new Value("Value");
    public static final Code CODE = new Code("Code");
    public static final Action CODE_LINE = new Action("CodeLine");
    public static final Annotation ANNOTATION = new Annotation("Annotation");
    public static final Comment COMMENT = new Comment("Comment");
    public static final None WHITESPACE = new None("Whitespace");
    public static final None VOID = new None("Void");

    public static final Statement STATEMENT = new Statement("Statement");
    public static final Statement BOOLEAN_STATEMENT = new Statement("BooleanStatement");
    public static final None NONE = new None();

    public static final x2<Name> VARIABLE_DECLARATION_START = new x2<>("VariableDeclarationStart", NAME);
    public static final B<x2<Name>, Value> VARIABLE_DECLARATION = new B<>("VariableDeclaration", VARIABLE_DECLARATION_START, VALUE);

    public static final Statement FUNCTION_CALL = new Statement("FunctionCall", VALUE);
    public static final Statement FUNCTION_RETURN = new Statement("FunctionReturn", VALUE);
    public static final E<None, Value> FUNCTION_PARAMETER_OPTIONAL = new E<>("FunctionParameterIsOptional", new None(), VALUE);
    public static final None FUNCTION_PARAMETER_VARARGS = new None("FunctionParameterIsVarargs");
    public static final E<E<None, Value>, None> FUNCTION_PARAMETER_EXTRAS = new E<>("FunctionParameterExtras", FUNCTION_PARAMETER_OPTIONAL, FUNCTION_PARAMETER_VARARGS);
    public static final O<E<E<None, Value>, None>> FUNCTION_PARAMETER_REQUIREMENT = new O<>("FunctionParameterRequirement", FUNCTION_PARAMETER_EXTRAS);
    public static final B<x2<Name>, O<E<E<None, Value>, None>>> FUNCTION_PARAMETER = new B<>("FunctionParameter", VARIABLE_DECLARATION_START, FUNCTION_PARAMETER_REQUIREMENT);
    public static final M<B<x2<Name>, O<E<E<None, Value>, None>>>> FUNCTION_PARAMETER_LIST = new M<>("FunctionParameterList", FUNCTION_PARAMETER);
    public static final Code FUNCTION_CODE = new Code("FunctionCode");
    public static final B<M<B<x2<Name>, O<E<E<None, Value>, None>>>>, Code> FUNCTION_DECLARATION = new B<>("FunctionDeclaration", FUNCTION_PARAMETER_LIST, FUNCTION_CODE);
    public static final E<Code, Statement> ANONYMOUS_FUNCTION_CODE = new E<>("AnonymousFunctionCode", FUNCTION_CODE, STATEMENT);
    public static final B<M<B<x2<Name>, O<E<E<None, Value>, None>>>>, Code> ANONYMOUS_FUNCTION_DECLARATION = new B<>("AnonymousFunctionDeclaration", FUNCTION_PARAMETER_LIST, FUNCTION_CODE);
    public static final Statement FUNCTION_REFERENCE = new Statement("FunctionReference");

    public static final Code METHOD_DECLARATION = new Code("MethodDeclaration", FUNCTION_DECLARATION);
    public static final C<B<M<B<x2<Name>, O<E<E<None, Value>, None>>>>, Code>> FUNCTION_LITERAL = new C<>("FunctionLiteral", FUNCTION_DECLARATION);
    public static final C<B<M<B<x2<Name>, O<E<E<None, Value>, None>>>>, Code>> ANONYMOUS_FUNCTION_LITERAL = new C<>("AnonymousFunctionLiteral", FUNCTION_DECLARATION);

    public static final Statement IF_CONDITION = new Statement("IfCondition");
    public static final Code IF_CODE = new Code("IfCode");
    public static final Code ELSE_CODE = new Code("ElseCode");
    public static final O<Code> OPT_ELSE_CODE = new O<>("ElseCode", ELSE_CODE);
    public static final B<Code, O<Code>> IF_ELSE_CODE = new B<>("IfElseCode", IF_CODE, OPT_ELSE_CODE);
    public static final B<Statement, B<Code, O<Code>>> IF_STATEMENT = new B<>("IfStatement", IF_CONDITION, IF_ELSE_CODE);

    public static final Statement WHILE_CONDITION = new Statement("WhileCondition");
    public static final Code WHILE_CODE = new Code("WhileCode");
    public static final B<Statement, Code> WHILE_LOOP = new B<>("WhileLoop", WHILE_CONDITION, WHILE_CODE);
    public static final B<Code, Statement> DO_WHILE_LOOP = new B<>("DoWhileLoop", WHILE_CODE, WHILE_CONDITION);
    public static final C<B<x2<Name>, Value>> FOR_VARIABLE = new C<>("ForVariable", VARIABLE_DECLARATION);
    public static final Statement FOR_CONDITION = new Statement("ForCondition");
    public static final Action FOR_ACTION = new Action("ForAction");
    public static final Code FOR_CODE = new Code("ForCode");
    public static final B<C<B<x2<Name>, Value>>, Statement> FOR_LOOP_TOP_RIGHT = new B<>("ForLoopTopRight", FOR_VARIABLE, FOR_CONDITION);
    public static final B<B<C<B<x2<Name>, Value>>, Statement>, Action> FOR_LOOP_TOP = new B<>("ForLoopTop", FOR_LOOP_TOP_RIGHT, FOR_ACTION);
    public static final B<B<B<C<B<x2<Name>, Value>>, Statement>, Action>, Code> FOR_LOOP = new B<>("ForLoop", FOR_LOOP_TOP, FOR_CODE);
    public static final B<C<B<x2<Name>, Value>>, Statement> FOR_IN_LOOP_TOP = new B<>("ForInLoopTop", FOR_VARIABLE, FOR_CONDITION);
    public static final B<C<B<x2<Name>, Value>>, Statement> FOR_OF_LOOP_TOP = new B<>("ForOfLoopTop", FOR_VARIABLE, FOR_CONDITION);
    public static final B<B<C<B<x2<Name>, Value>>, Statement>, Code> FOR_IN_LOOP = new B<>("ForInLoop", FOR_IN_LOOP_TOP, FOR_CODE);
    public static final B<B<C<B<x2<Name>, Value>>, Statement>, Code> FOR_OF_LOOP = new B<>("ForOfLoop", FOR_OF_LOOP_TOP, FOR_CODE);

    public static final Value BOOLEAN_LITERAL = new Value("BooleanLiteral");
    public static final Value BYTE_LITERAL = new Value("ByteLiteral");
    public static final Value SHORT_LITERAL = new Value("ShortLiteral");
    public static final Value INTEGER_LITERAL = new Value("IntegerLiteral");
    public static final Value LONG_LITERAL = new Value("LongLiteral");
    public static final Value LONG_LONG_LITERAL = new Value("LongLongLiteral");
    public static final Value FLOAT_LITERAL = new Value("FloatLiteral");
    public static final Value DOUBLE_LITERAL = new Value("DoubleLiteral");
    public static final Value CHAR_LITERAL = new Value("CharLiteral");
    public static final Value STRING_LITERAL = new Value("StringLiteral");
    public static final Value ARRAY_LITERAL = new Value("ArrayLiteral");
    public static final Value OBJECT_LITERAL = new Value("ObjectLiteral");

    public O<T> optional() {
        return new O<>(this.name, this);
    }
    public <U extends ProgramPartType<?>> E<ProgramPartType<T>, U> or(U other) {
        return new E<>(name, this, other);
    }
    public M<T> multiple() {
        return new M<>(name, this);
    }

    public boolean valid(ProgramPartType<?> type) {
        return type == this
            || type == other
            || Arrays.equals(this.subtypes, type.subtypes)
            || (multiple && Stream.of(type.subtypes).allMatch(this::valid))
            || (type.multiple && Stream.of(subtypes).allMatch(type::valid))
            || (optional && type == NONE);
    }
    public boolean equals(Object other) {
        return this == other || (other instanceof ProgramPartType pt && name.equals(pt.name) && valid(pt));
    }
    
    public static class None extends ProgramPartType<None> {
        public None() {
            super();
        }
        public None(String name) {
            super(name);
        }
    }
    public static class C<T> extends ProgramPartType<C<T>> {
        protected C(String name, ProgramPartType<?> type) {
            super(name, type);
        }
    }
    public static class O<T> extends ProgramPartType<O<T>> {
        protected O(String name, ProgramPartType<?> type) {
            super(name, true, type);
        }
    }
    public static class M<T> extends ProgramPartType<M<T>> {
        protected M(String name, ProgramPartType<?>... type) {
            super(name, false, true, type);
        }
    }
    public static class E<T extends ProgramPartType<?>, U extends ProgramPartType<?>> extends ProgramPartType<E<T, U>> {
        protected E(String name, T type1, U type2) {
            super(name, type1, type2);
        }
    }
    public static class B<T extends ProgramPartType<?>, U extends ProgramPartType<?>> extends ProgramPartType<E<T, U>> {
        protected B(String name, T type1, U type2) {
            super(name, type1, type2);
        }
    }
    public static class x2<T extends ProgramPartType<?>> extends ProgramPartType<B<T, T>> {
        protected x2(String name, T type) {
            super(name, type, type);
        }
    }
}