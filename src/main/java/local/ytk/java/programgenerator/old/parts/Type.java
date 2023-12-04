package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.parts.Builder.Ref;
import local.ytk.java.programgenerator.old.parts.Name.NRef;

public class Type extends ProgramPartType<Type> {
    public Type(String name) {
        super(name);
    }

    public static class TRef extends Ref<Type> {
        public TRef(Type t, NRef name) {
            super(t);
            this.name = name;
        }
        public final NRef name;
    }
}
