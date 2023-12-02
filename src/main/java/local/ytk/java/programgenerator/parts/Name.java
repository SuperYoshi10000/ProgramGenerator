package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public class Name extends ProgramPartType<Name> {
    public Name(String name) {
        super(name);
    }

    public static class NRef extends Ref<Name> {
        public NRef(Name t, String name) {
            super(t);
            this.name = name;
        }
        public final String name;
    }
}
