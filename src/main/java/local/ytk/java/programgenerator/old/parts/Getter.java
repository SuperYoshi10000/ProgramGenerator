package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.parts.Builder.Ref;
import local.ytk.java.programgenerator.old.parts.Name.NRef;

public class Getter extends Statement {
    public Getter(String name) {
        super(name);
    }

    public static class GRef extends Ref<Getter> {
        public GRef(Getter t, NRef name) {
            super(t);
            this.name = name;
        }
        public final NRef name;
    }
}