package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;
import local.ytk.java.programgenerator.parts.Name.NRef;

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