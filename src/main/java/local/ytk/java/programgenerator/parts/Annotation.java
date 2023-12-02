package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;
import local.ytk.java.programgenerator.parts.Name.NRef;

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
