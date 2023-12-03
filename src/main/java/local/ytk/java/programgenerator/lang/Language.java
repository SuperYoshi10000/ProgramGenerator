package local.ytk.java.programgenerator.lang;

import java.util.HashMap;
import java.util.function.BiFunction;

import com.google.common.collect.ImmutableMap;

import local.ytk.java.programgenerator.parts.*;
import local.ytk.java.programgenerator.parts.Action.ARef;
import local.ytk.java.programgenerator.parts.Annotation.AnRef;
import local.ytk.java.programgenerator.parts.Builder.Ref;
import local.ytk.java.programgenerator.parts.Code.CRef;
import local.ytk.java.programgenerator.parts.Comment.CmRef;
import local.ytk.java.programgenerator.parts.Getter.GRef;
import local.ytk.java.programgenerator.parts.Keyword.KRef;
import local.ytk.java.programgenerator.parts.Name.NRef;
import local.ytk.java.programgenerator.parts.Operation.*;
import local.ytk.java.programgenerator.parts.Operation.DoubleOp.O2Ref;
import local.ytk.java.programgenerator.parts.Operation.SingleOp.O1Ref;
import local.ytk.java.programgenerator.parts.Operation.TripleOp.O3Ref;
import local.ytk.java.programgenerator.parts.ProgramGeneratorFunction.*;
import local.ytk.java.programgenerator.parts.Statement.SRef;
import local.ytk.java.programgenerator.parts.Type.TRef;
import local.ytk.java.programgenerator.parts.Value.VRef;

public abstract class Language {
    public Language() {
        init(programPartTypes::put);
    }
    protected final HashMap<ProgramPartType<?>, ProgramGeneratorFunction<?>> programPartTypes = new HashMap<>();
    protected static <T extends ProgramPartType<?>> ImmutableMap<String,ProgramGeneratorFunction<T>.ProgramGeneratorArgument> map(Class<T> type) {
        return ImmutableMap.of();
    }
    public <T extends ProgramPartType<?>> String generate(Ref<T> t) {
        if (programPartTypes.get(t.type) instanceof ProgramActionGenerator     g && t instanceof ARef  r) return g.generate(r, map(Action.class    ));
        if (programPartTypes.get(t.type) instanceof ProgramAnnotationGenerator g && t instanceof AnRef r) return g.generate(r, map(Annotation.class));
        if (programPartTypes.get(t.type) instanceof ProgramCodeGenerator       g && t instanceof CRef  r) return g.generate(r, map(Code.class      ));
        if (programPartTypes.get(t.type) instanceof ProgramCommentGenerator    g && t instanceof CmRef r) return g.generate(r, map(Comment.class   ));
        if (programPartTypes.get(t.type) instanceof ProgramGetterGenerator     g && t instanceof GRef  r) return g.generate(r, map(Getter.class    ));
        if (programPartTypes.get(t.type) instanceof ProgramKeywordGenerator    g && t instanceof KRef  r) return g.generate(r, map(Keyword.class   ));
        if (programPartTypes.get(t.type) instanceof ProgramNameGenerator       g && t instanceof NRef  r) return g.generate(r, map(Name.class      ));
        if (programPartTypes.get(t.type) instanceof ProgramSingleOpGenerator   g && t instanceof O1Ref r) return g.generate(r, map(SingleOp.class  ));
        if (programPartTypes.get(t.type) instanceof ProgramDoubleOpGenerator   g && t instanceof O2Ref r) return g.generate(r, map(DoubleOp.class  ));
        if (programPartTypes.get(t.type) instanceof ProgramTripleOpGenerator   g && t instanceof O3Ref r) return g.generate(r, map(TripleOp.class  ));
        if (programPartTypes.get(t.type) instanceof ProgramStatementGenerator  g && t instanceof SRef  r) return g.generate(r, map(Statement.class ));
        if (programPartTypes.get(t.type) instanceof ProgramTypeGenerator       g && t instanceof TRef  r) return g.generate(r, map(Type.class      ));
        if (programPartTypes.get(t.type) instanceof ProgramValueGenerator      g && t instanceof VRef  r) return g.generate(r, map(Value.class     ));
        return "";
    }
    protected abstract void init(Language.Builder m);
    protected interface Builder extends BiFunction<ProgramPartType<?>, ProgramGeneratorFunction<?>, ProgramGeneratorFunction<?>> {
        public default <T extends ProgramPartType<?>, F extends ProgramGeneratorFunction<T>> F add(T t, F f)  {
            apply(t, f);
            return f;
        }
        
    }
}
