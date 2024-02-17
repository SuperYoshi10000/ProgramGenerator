package local.ytk.tools.programgen2.build;

import local.ytk.tools.programgen2.parts.Program;

public interface Builder {
    GeneratedProgram build(Program program);

    default void save(Program program) throws Exception {
        build(program).save();
    }
    default void compile(Program program) throws Exception {
        build(program).compile();
    }
}
