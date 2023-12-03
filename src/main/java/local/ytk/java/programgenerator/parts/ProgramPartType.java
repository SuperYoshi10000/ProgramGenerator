package local.ytk.java.programgenerator.parts;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class ProgramPartType<T extends ProgramPartType<?>> {
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
        this(name, false, false, NONE, type);
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

    public static final Keyword KEYWORD = Keyword("Keyword");
    public static final Type TYPE = Type("Type");
    public static final Name NAME = Name("Name");
    public static final Value VALUE = Value("Value");
    public static final Code CODE = Code("Code");
    public static final Action CODE_LINE = Action("CodeLine");
    public static final Annotation ANNOTATION = Annotation("Annotation");
    public static final Comment COMMENT = Comment("Comment");
    public static final None WHITESPACE = new None("Whitespace");
    public static final None VOID = new None("Void");

    public static final Statement STATEMENT = Statement("Statement");
    public static final Statement BOOLEAN_STATEMENT = Statement("BooleanStatement");
    public static final None NONE = new None();

    public static final B<Type, Name> VARIABLE_DECLARATION_START = B("VariableDeclarationStart", TYPE, NAME);
    public static final O<Value> OP_VALUE = O("OptionalValue", VALUE);
    public static final B<B<Type, Name>, O<Value>> VARIABLE_DECLARATION = B("VariableDeclaration", VARIABLE_DECLARATION_START, OP_VALUE);

    public static final Statement FUNCTION_CALL = Statement("FunctionCall", VALUE);
    public static final Statement FUNCTION_RETURN = Statement("FunctionReturn", VALUE);
    public static final E<None, Value> FUNCTION_PARAMETER_OPTIONAL = E("FunctionParameterIsOptional", new None(), VALUE);
    public static final None FUNCTION_PARAMETER_VARARGS = new None("FunctionParameterIsVarargs");
    public static final E<E<None, Value>, None> FUNCTION_PARAMETER_EXTRAS = E("FunctionParameterExtras", FUNCTION_PARAMETER_OPTIONAL, FUNCTION_PARAMETER_VARARGS);
    public static final O<E<E<None, Value>, None>> FUNCTION_PARAMETER_REQUIREMENT = O("FunctionParameterRequirement", FUNCTION_PARAMETER_EXTRAS);
    public static final B<B<Type, Name>, O<E<E<None, Value>, None>>> FUNCTION_PARAMETER = B("FunctionParameter", VARIABLE_DECLARATION_START, FUNCTION_PARAMETER_REQUIREMENT);
    public static final M<B<B<Type, Name>, O<E<E<None, Value>, None>>>> FUNCTION_PARAMETER_LIST = M("FunctionParameterList", FUNCTION_PARAMETER);
    public static final Code FUNCTION_CODE = Code("FunctionCode");
    public static final B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code> FUNCTION_DECLARATION = B("FunctionDeclaration", FUNCTION_PARAMETER_LIST, FUNCTION_CODE);
    public static final E<Code, Statement> ANONYMOUS_FUNCTION_CODE = E("AnonymousFunctionCode", FUNCTION_CODE, STATEMENT);
    public static final B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code> ANONYMOUS_FUNCTION_DECLARATION = B("AnonymousFunctionDeclaration", FUNCTION_PARAMETER_LIST, FUNCTION_CODE);
    public static final Statement FUNCTION_REFERENCE = Statement("FunctionReference");

    public static final M<Annotation> ANNOTATION_LIST = M("AnnotationList", ANNOTATION);

    public static final M<Keyword> MODIFIERS = M("Modifiers", KEYWORD);
    public static final B<M<Annotation>, M<Keyword>> ANNOTATIONS_AND_MODIFIERS = B("AnnotationsAndModifiers", ANNOTATION_LIST, MODIFIERS);
    public static final B<B<M<Annotation>, M<Keyword>>, B<B<Type, Name>, O<Value>>> FIELD_DECLARATION = B("FieldDeclaration", ANNOTATIONS_AND_MODIFIERS, VARIABLE_DECLARATION);
    public static final C<B<B<Type, Name>, O<Value>>> SCOPED_VARIABLE_DECLARATION = C("ScopedVariableDeclaration", VARIABLE_DECLARATION);
    public static final B<B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code>, B<M<Annotation>, M<Keyword>>> METHOD_DECLARATION = B("MethodDeclaration", FUNCTION_DECLARATION, ANNOTATIONS_AND_MODIFIERS);
    public static final B<M<Keyword>, B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code>> FUNCTION_LITERAL = B("FunctionLiteral", MODIFIERS, FUNCTION_DECLARATION);
    public static final C<B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code>> ANONYMOUS_FUNCTION_LITERAL = C("AnonymousFunctionLiteral", FUNCTION_DECLARATION);

    public static final Statement IF_CONDITION = Statement("IfCondition");
    public static final Code IF_CODE = Code("IfCode");
    public static final Code ELSE_CODE = Code("ElseCode");
    public static final O<Code> OPT_ELSE_CODE = O("ElseCode", ELSE_CODE);
    public static final B<Code, O<Code>> IF_ELSE_CODE = B("IfElseCode", IF_CODE, OPT_ELSE_CODE);
    public static final B<Statement, B<Code, O<Code>>> IF_STATEMENT = B("IfStatement", IF_CONDITION, IF_ELSE_CODE);

    public static final Statement WHILE_CONDITION = Statement("WhileCondition");
    public static final Code WHILE_CODE = Code("WhileCode");
    public static final B<Statement, Code> WHILE_LOOP = B("WhileLoop", WHILE_CONDITION, WHILE_CODE);
    public static final B<Code, Statement> DO_WHILE_LOOP = B("DoWhileLoop", WHILE_CODE, WHILE_CONDITION);
    public static final C<B<B<Type, Name>, O<Value>>> FOR_VARIABLE = C("ForVariable", VARIABLE_DECLARATION);
    public static final Statement FOR_CONDITION = Statement("ForCondition");
    public static final Action FOR_ACTION = Action("ForAction");
    public static final Code FOR_CODE = Code("ForCode");
    public static final B<C<B<B<Type, Name>, O<Value>>>, Statement> FOR_LOOP_TOP_RIGHT = B("ForLoopTopRight", FOR_VARIABLE, FOR_CONDITION);
    public static final B<B<C<B<B<Type, Name>, O<Value>>>, Statement>, Action> FOR_LOOP_TOP = B("ForLoopTop", FOR_LOOP_TOP_RIGHT, FOR_ACTION);
    public static final B<B<B<C<B<B<Type, Name>, O<Value>>>, Statement>, Action>, Code> FOR_LOOP = B("ForLoop", FOR_LOOP_TOP, FOR_CODE);
    public static final B<C<B<B<Type, Name>, O<Value>>>, Statement> FOR_IN_LOOP_TOP = B("ForInLoopTop", FOR_VARIABLE, FOR_CONDITION);
    public static final B<C<B<B<Type, Name>, O<Value>>>, Statement> FOR_OF_LOOP_TOP = B("ForOfLoopTop", FOR_VARIABLE, FOR_CONDITION);
    public static final B<B<C<B<B<Type, Name>, O<Value>>>, Statement>, Code> FOR_IN_LOOP = B("ForInLoop", FOR_IN_LOOP_TOP, FOR_CODE);
    public static final B<B<C<B<B<Type, Name>, O<Value>>>, Statement>, Code> FOR_OF_LOOP = B("ForOfLoop", FOR_OF_LOOP_TOP, FOR_CODE);

    public static final Common.ClassMember CLASS_MEMBER = new Common.ClassMember("ClassMember", E("ClassFieldOrMethod", FIELD_DECLARATION, METHOD_DECLARATION));
    public static final M<Common.ClassMember> CLASS_BODY = M("ClassBody", CLASS_MEMBER);
    public static final B<B<M<Annotation>, M<Keyword>>, M<Common.ClassMember>> CLASS = B("Class", ANNOTATIONS_AND_MODIFIERS, CLASS_BODY);

    public static final Common.Generic GENERIC = new Common.Generic("Generic", NAME);
    public static final B<B<Name, O<Common.Generic>>, M<Common.ClassMember>> NAMED_CLASS = new B<>(null, null, null);

    public static final Value BOOLEAN_LITERAL = Value("BooleanLiteral");
    public static final Value BYTE_LITERAL = Value("ByteLiteral");
    public static final Value SHORT_LITERAL = Value("ShortLiteral");
    public static final Value INTEGER_LITERAL = Value("IntegerLiteral");
    public static final Value LONG_LITERAL = Value("LongLiteral");
    public static final Value LONG_LONG_LITERAL = Value("LongLongLiteral");
    public static final Value FLOAT_LITERAL = Value("FloatLiteral");
    public static final Value DOUBLE_LITERAL = Value("DoubleLiteral");
    public static final Value CHAR_LITERAL = Value("CharLiteral");
    public static final Value STRING_LITERAL = Value("StringLiteral");
    public static final Value ARRAY_LITERAL = Value("ArrayLiteral");
    public static final Value OBJECT_LITERAL = Value("ObjectLiteral");

    @Deprecated
    public O<ProgramPartType<T>> optional() {
        return new O<>(this.name, this);
    }
    @Deprecated
    public <U extends ProgramPartType<?>> E<ProgramPartType<T>, U> or(U other) {
        return new E<>(name, this, other);
    }
    @Deprecated
    public M<ProgramPartType<T>> multiple() {
        return new M<>(name, this);
    }
    
    public static <T extends ProgramPartType<?>> O<T> O(String name, T t) {
        return new O<>(name, t);
    }
    public static <T extends ProgramPartType<?>> C<T> C(String name, T t) {
        return new C<>(name, t);
    }
    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> E<T, U> E(String name, T t, U u) {
        return new E<>(name, t, u);
    }
    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> B<T, U> B(String name, T t, U u) {
        return new B<>(name, t, u);
    }
    public static <T extends ProgramPartType<?>> x2<T> two(String name, T t) {
        return new x2<T>(name, t);
    }
    public static <T extends ProgramPartType<?>> M<T> M(String name, T t) {
        return new M<>(name, t);
    }
    public static <T extends ProgramPartType<?>> O<T> O(T t) {
        return new O<>(t.name, t);
    }
    public static <T extends ProgramPartType<?>> C<T> C(T t) {
        return new C<>(t.name, t);
    }
    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> E<T, U> E(T t, U u) {
        return new E<>(t.name, t, u);
    }
    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> B<T, U> B(T t, U u) {
        return new B<>(t.name, t, u);
    }
    public static <T extends ProgramPartType<?>> x2<T> two(T t) {
        return new x2<T>(t.name, t);
    }
    public static <T extends ProgramPartType<?>> M<T> M(T t) {
        return new M<>(t.name, t);
    }

    public static Action Action(String name) {
        return new Action(name);
    }
    public static Annotation Annotation(String name) {
        return new Annotation(name);
    }
    public static Code Code(String name) {
        return new Code(name);
    }
    public static Comment Comment(String name) {
        return new Comment(name);
    }
    public static Getter Getter(String name) {
        return new Getter(name);
    }
    public static Keyword Keyword(String name) {
        return new Keyword(name);
    }
    public static Name Name(String name) {
        return new Name(name);
    }
    public static Operation SingleOp(String name) {
        return new Operation.SingleOp(name);
    }
    public static Operation DoubleOp(String name) {
        return new Operation.DoubleOp(name);
    }
    public static Operation TripleOp(String name) {
        return new Operation.TripleOp(name);
    }
    public static Statement Statement(String name) {
        return new Statement(name);
    }
    public static Statement Statement(String name, ProgramPartType<?>... type) {
        return new Statement(name, type);
    }
    public static Type Type(String name) {
        return new Type(name);
    }
    public static Value Value(String name) {
        return new Value(name);
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
    public static class C<T extends ProgramPartType<?>> extends ProgramPartType<C<T>> {
        protected C(String name, T type) {
            super(name, type);
        }
    }
    public static class O<T extends ProgramPartType<?>> extends ProgramPartType<O<T>> {
        protected O(String name, T type) {
            super(name, true, type);
        }
    }
    public static class M<T extends ProgramPartType<?>> extends ProgramPartType<M<T>> {
        protected M(String name, T type) {
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