package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.parts.Builder.Ref;
import local.ytk.java.programgenerator.old.parts.Name.NRef;

public class Annotation extends ProgramPartType<Annotation> {
    public Annotation(String name) {
        super(name);
    }
    public static class AnRef extends Ref<Annotation> {
        public AnRef(Annotation t, NRef name) {
            super(t);
            this.name = name;
        }
        public final NRef name;
    }
}
