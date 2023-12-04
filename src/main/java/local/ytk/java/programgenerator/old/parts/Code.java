package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.parts.Action.ARef;
import local.ytk.java.programgenerator.old.parts.Builder.Ref;

public class Code extends ProgramPartType<Code> {
    public Code(String name) {
        super(name);
    }

    public Code(String name, ProgramPartType<?> function) {
        super(name, function);
    }
    
    public static class CRef extends Ref<Code> {
        public CRef(Code t, ARef... code) {
            super(t);
            this.code = code;
        }
        public final ARef[] code;
    }
}
