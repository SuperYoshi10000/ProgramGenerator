package local.ytk.tools.programgen2.parts.group;

import java.util.function.Function;

import local.ytk.tools.programgen2.parts.ProgramPart;

public interface Either<A extends ProgramPart, B extends ProgramPart> extends ProgramPart {
    A a();
    B b();
    Which which();
    
    ProgramPart get();
    default B mapA(Function<A, B> mapper) {
        if (which() == Which.A) return mapper.apply(a());
        return b();
    }
    default A mapB(Function<B, A> mapper) {
        if (which() == Which.B) return mapper.apply(b());
        return a();
    }
    default <C extends ProgramPart> C mapBoth(Function<A, C> mapperA, Function<B, C> mapperB) {
        if (which() == Which.A) return mapperA.apply(a());
        return mapperB.apply(b());
    }

    public static enum Which { A, B }

    public interface List<A extends ProgramPart, B extends ProgramPart> extends java.util.List<Either<A, B>> {}
}
