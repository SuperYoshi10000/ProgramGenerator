package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;
import local.ytk.java.programgenerator.parts.Name.NRef;

public class Keyword extends ProgramPartType<Keyword> {
    public Keyword(String name) {
        super(name);
    }

    public static class KRef extends Ref<Keyword> {
        public KRef(Keyword t, NRef name) {
            super(t);
            this.name = name;
        }
        public final NRef name;
    }
}
