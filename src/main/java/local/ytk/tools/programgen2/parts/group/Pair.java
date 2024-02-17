package local.ytk.tools.programgen2.parts.group;

import local.ytk.tools.programgen2.parts.ProgramPart;

public interface Pair<A extends ProgramPart, B extends ProgramPart> extends ProgramPart {
    A a();
    B b();
    public interface List<A extends ProgramPart, B extends ProgramPart> extends java.util.List<Pair<A, B>> {}
}
