package local.ytk.java.programgenerator.builder;

public class Method<T extends Type<T>> extends Member<T> {
    public Method(Identifier name, T type) {
        super(name, type);
    }

    public static class Constructor<T extends Type<T>> extends Method<T> {
        public Constructor(T type) {
            super(type, type);
        }
    }
}