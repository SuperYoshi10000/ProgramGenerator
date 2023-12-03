package local.ytk.java.programgenerator.lang;

import local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.*;
import local.ytk.java.programgenerator.parts.Statement.SRef;
import local.ytk.java.programgenerator.parts.Value.VRef;

import static local.ytk.java.programgenerator.parts.ProgramPartType.*;

import local.ytk.java.programgenerator.parts.*;
import local.ytk.java.programgenerator.parts.Builder.OpRef;

import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramActionGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramAnnotationGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramCodeGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramCommentGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramGetterGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramKeywordGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramNameGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramSingleOpGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramDoubleOpGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramTripleOpGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramStatementGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramTypeGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramValueGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramOpGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramCpGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramBothGenerator.of;
import static local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.ProgramEitherGenerator.of;


@SuppressWarnings("unused")

public class JavaLang extends Language {
    @Override
    protected void init(Language.Builder m) {
        ProgramNameGenerator name = m.add(NAME, ProgramNameGenerator.TOSTRING);
        ProgramTypeGenerator type = m.add(TYPE, ProgramTypeGenerator.TOSTRING);
        ProgramValueGenerator value = m.add(VALUE, ProgramValueGenerator.of((a, b) -> a instanceof VRef v ? v.code : ""));
        ProgramOpGenerator<O<Value>> opValue = m.add(OP_VALUE, ProgramOpGenerator.of(value));
        ProgramStatementGenerator statement = m.add(STATEMENT, ProgramStatementGenerator.of((a, b) -> a instanceof SRef s ? s.code : ""));
        ProgramBothGenerator<B<Type, Name>> varDeclSt = m.add(VARIABLE_DECLARATION_START, of(type, name, (a, b) -> a + " " + b));
        ProgramBothGenerator<B<B<Type, Name>, O<Value>>> varDecl = m.add(VARIABLE_DECLARATION, ProgramBothGenerator.of(varDeclSt, opValue, (a, b) -> a + " = " + b));
    }
}
