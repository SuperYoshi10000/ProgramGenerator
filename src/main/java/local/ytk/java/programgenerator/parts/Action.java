package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public class Action extends ProgramPartType<Code> {
    public Action(String name) {
        super(name);
    }

    public Action(String name, ProgramPartType<?> function) {
        super(name, function);
    }
    
    public static class ARef extends Ref<Action> {
        public ARef(Action t, String code) {
            super(t);
            this.code = code;
        }
        public final String code;
    }
}
