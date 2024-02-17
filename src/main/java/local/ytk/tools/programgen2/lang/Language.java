package local.ytk.tools.programgen2.lang;

import java.util.List;

import local.ytk.tools.programgen2.build.*;
import local.ytk.tools.programgen2.build.Package;
import local.ytk.tools.programgen2.expression.*;
import local.ytk.tools.programgen2.expression.operator.*;
import local.ytk.tools.programgen2.parts.*;
import local.ytk.tools.programgen2.parts.Class;
import local.ytk.tools.programgen2.parts.accessor.*;
import local.ytk.tools.programgen2.parts.declarations.*;
import local.ytk.tools.programgen2.parts.group.*;
import local.ytk.tools.programgen2.parts.literal.*;
import local.ytk.tools.programgen2.statement.*;
import local.ytk.tools.programgen2.statement.block.*;
import local.ytk.tools.programgen2.statement.io.*;
import local.ytk.tools.programgen2.type.*;
import local.ytk.tools.programgen2.value.*;
import local.ytk.tools.programgen2.value.ClassValue;

public interface Language {
    public default Builder builder() {
        return build().builder();
    }
    public default GeneratedProgram generate(Program program) {
        return build().builder().build(program);
    }

    Build build();
    Expressions expressions();
    Statements statements();
    Types types();
    Values values();
    Accessors accessors();
    Declarations declarations();
    Definitions definitions();
    Literals literals();
    Parts parts();
    Groups groups();

    // BUILD
    public interface Build {
        ClassFile classFile(List<Class> classes);
        DeclarationFile declarationFile(List<Declaration> declarations);
        FileContainer fileContainer(List<ProgramFile> files);
        Package newPackage(List<ProgramFile> files, List<Package> subpackages);
        ProgramFile programFile();
        Script script(List<Either<Statement, Declaration>> components);
        ScriptFile scriptFile(Script script);
        Builder builder();
    }
    // EXPRESSIONS
    public interface Expressions {
        ArgumentList argumentList(List<Expression> expressions);
        Expression expression();
        ExpressionList expressionList(List<Expression> expressions);
        FunctionExpression function(FunctionCall function);
        LiteralExpression literal(Literal literal);
        OperatorExpression operatorExpr(Operator op);
        UnaryOperatorExpression unaryOpExpr(UnaryOperator op);
        BinaryOperatorExpression binaryOpExpr(BinaryOperator op);
        TernaryOperatorExpression ternaryOpExpr(TernaryOperator op);
    
        Operator operator();
        UnaryOperator unaryOperator(Expression a);
        BinaryOperator binaryOperator(Expression a, Expression b);
        TernaryOperator ternaryOperator(Expression a, Expression b, Expression c);

    }
    // STATEMENTS
    public interface Statements {
        Statement statement();
        ExpressionStatement expression(Expression expr);
        FunctionCall function(Function function, ArgumentList args);
        LocalVariableDeclaration variableDecl(LocalVariable var, Type type, ModifierList mods);
        LocalVariableDefinition variableDef(LocalVariable var, Type type, ModifierList mods, Expression expr);
        ReturnStatement returns(Expression expr);
        StatementList statementList(List<Statement> statements);
        
        Block block();

        HasValueStatement value();
        IOStatement io();
        InputStatement in();
        OutputStatement out(Expression expr);

    }

    public interface Types {
        Type type(String key);
        AnyType any(String key);
        <T extends Type> ArrayType<T> array(T type);
        BooleanType bool(String key);
        CharacterType character(String key);
        ClassType classType(Class class1);
        EnumType enumType(String key);
        FunctionType function(String key);
        GenericType generic(String key);
        NullType nullType(String key);
        NumericType numeric(String key);
        ObjectType object(String key);
        ErrorType error(String key);
        PrimitiveType primitive(String key);
        SpecialType special(String key);
        StringType string(String key);
        TypeType typeType(Type type);
        VoidType voidType(String key);

        <T extends Type> HasGenericType withGenerics(T type, GenericType... generics);
    }

    public interface Values {
        Value value();
        <T extends Type> ArrayValue<T> array(T value);
        BooleanValue bool(boolean b);
        CharacterValue character(char c);
        ClassValue classValue(Class class1);
        EnumValue enumValue();
        FunctionValue function(Function function);
        NullValue nullValue(String key);
        NumericValue numeric(Number num);
        ObjectValue object();
        ErrorValue error();
        PrimitiveValue primitive();
        SpecialValue special();
        StringValue string(String str);
        TypeValue typeValue(Type type);
    }

    // TODO Add Parts methods
    public interface Accessors {
        Accessor accessor();
        ArrayAccessor array(Expression array, String index);
        FieldAccessor field(Field field);
        MemberAccessor member(Member member);
        MethodAccessor method(Method method);
        DynamicAccessor dynamic();
        PropertyAccessor property(Property prop);
    }
    public interface Declarations {
        Declaration declaration(ProgramComponent comp, Type type);
        FieldDeclaration field(Field f, Type type, ModifierList mods);
        FunctionDeclaration function(Function func, Type type);
        MemberDeclaration member(Member member, Type type, ModifierList mods);
        MethodDeclaration method(Method method, Type type, ModifierList mods);
        ParameterDeclaration paramater(Parameter param, Type type, ModifierList mods);
        PropertyDeclaration property(Property prop, Type type, ModifierList mods);
        VariableDeclaration variable(Variable var, Type type, ModifierList mods);
    }
    public interface Definitions {
        Definition definition(ProgramComponent comp, Type type);
        FieldDefinition field(Field f, Type type, ModifierList mods, Value value);
        FunctionDefinition function(Function func, Type type);
        FunctionValueDefinition functionValue(Function func, Type type, FunctionValue value);
        InlineFunctionDefinition inline(Function func, Type type, Block block);
        LambdaFunctionDefinition lambda(Function func, Type type);
        LambdaFunctionBlockDefinition lambdaBlock(Function func, Type type, Block block);
        LambdaFunctionValueDefinition lambdaValue(Function func, Type type, Value value);
        MemberDefinition member(Member member, Type type, ModifierList mods);
        MethodDefinition method(Method method, Type type, ModifierList mods, Block block);
        ParameterDefinition parameter(Parameter param, Type type, ModifierList mods, Value value);
        PropertyDefinition property(Property prop, Type type, ModifierList mods, Value value);
        VariableDefinition variable(Variable var, Type type, ModifierList mods, Value value);
    }

    public interface Literals {
        Literal literal();
        ConstantLiteral constant();
        ArrayLiteral array(List<Expression> expressions);
        BooleanLiteral bool(boolean state);
        CharacterLiteral character(char c);
        NullLiteral nullLiteral();
        NumberLiteral number(Number number);
        ObjectLiteral object(List<PropertyDeclaration> properties);
        StringLiteral string(String str);
        DynamicLiteral dynamic();
        TemplateLiteral template();
        ClassLiteral classLiteral();
        FunctionLiteral function();
    }

    // TODO Add some new parts: Annotation, TypeModifier, AbstractClass, Enum(erable), Interface, TupleType, for, while, do, if/elseif/else, switch, try/catch/finally, for each, for in, destructuring, ...

    public interface Parts {
        MemberContainer memberContainer();
        Class class1(List<Member> members);
        Member member(Identifier id, ModifierList mods);
        Function function(ModifierList mods, ParameterList params, ThrowsList throwsList, Type returnType, Block block);
        Constructor constructor(Identifier id, ModifierList mods, ParameterList params, ThrowsList throwsList, Type returnType, Block block);
        Method method(Identifier id, ModifierList mods, ParameterList params, ThrowsList throwsList, Type returnType, Block block);
        Field field(Identifier id, ModifierList mods, Type type);
        Initializer init(Block block);
        Keyword keyword(Identifier id);
        Modifier modifier(Identifier id);
        ModifierList modifierList(List<Modifier> mods);
        Namespace namespace(Identifier id);
        Parameter parameter(Identifier id, Type type);
        ParameterList parameterList(List<ParameterDeclaration> params);
        Program program(FileContainer container);
        Property property(Identifier id);
        Template template(List<TemplatePart> parts);
        TemplatePart templatePart(Type type); // idk what this is
        Throws throws1(ErrorType errorType);
        ThrowsList throwsList(List<Throws> throws1);
        
        Scope scope();
        GlobalScope globalScope();
        Variable var(Identifier id, ModifierList mods, Type type);
        GlobalVariable global(Identifier id, ModifierList mods, Type type);
        LocalVariable local(Identifier id, ModifierList mods, Type type);
        Assignment assignment(BinaryOperatorExpression op);
        Identifiable identifiable(Identifier id);
        Identifier identifier(String name);
        IdentifierPart identifierPart(Identifier id);
        
        ProgramComponent component();
        ProgramPart part();
        ProgramValue value();
    }

    public interface Groups {
        <A extends ProgramPart, B extends ProgramPart> Either<A, B> eitherA(A a);
        <A extends ProgramPart, B extends ProgramPart> Either<A, B> eitherB(B b);
        <A extends ProgramPart, B extends ProgramPart> Pair<A, B> pair(A a, B b);

        <A extends Type, B extends Type> UnionType<A, B> unionA(A a);
        <A extends Type, B extends Type> UnionType<A, B> unionB(B b);
        // a should equal b
        <A extends Type, B extends Type> IntersectionType<A, B> intersect(A a, B b);
        default <A extends Type, B extends Type> IntersectionType<A, B> checkIntersect(A a, B b) {
            if (a != b) throw new IllegalArgumentException();
            return intersect(a, b);
        }
    }
}
