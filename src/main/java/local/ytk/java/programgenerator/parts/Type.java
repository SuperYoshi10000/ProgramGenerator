package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;
import local.ytk.java.programgenerator.parts.Name.NRef;

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
