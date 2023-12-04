package local.ytk.java.programgenerator.old.lang;

import static local.ytk.java.programgenerator.old.parts.ProgramGeneratorFunction.ProgramBothGenerator.of;
import static local.ytk.java.programgenerator.old.parts.ProgramPartType.*;

import local.ytk.java.programgenerator.old.parts.*;
import local.ytk.java.programgenerator.old.parts.Builder.OpRef;
import local.ytk.java.programgenerator.old.parts.ProgramGeneratorFunction.*;
import local.ytk.java.programgenerator.old.parts.Statement.SRef;
import local.ytk.java.programgenerator.old.parts.Value.VRef;


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
