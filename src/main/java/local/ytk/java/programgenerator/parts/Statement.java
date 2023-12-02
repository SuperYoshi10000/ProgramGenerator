package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public class Statement extends ProgramPartType<Statement> {
    protected Statement(String name) {
        super(name);
    }

    protected Statement(String name, ProgramPartType<?>... type) {
        super(name, type);
    }
    
    public static class SRef extends Ref<Statement> {
        public SRef(Statement t, String code) {
            super(t);
            this.code = code;
        }
        public final String code;
    }
}
