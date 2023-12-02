package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public class Value extends Statement {
    public Value(String name) {
        super(name);
    }

    public static class VRef extends Ref<Value> {
        public VRef(Value t, String code) {
            super(t);
            this.code = code;
        }
        public final String code;
    }
}
