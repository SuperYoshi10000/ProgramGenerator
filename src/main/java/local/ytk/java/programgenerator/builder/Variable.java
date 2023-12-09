package local.ytk.java.programgenerator.builder;

public interface Variable<T extends Type<T>> extends HasValue<T> {
    T type();
    Value<T> getValue();
    boolean isFinal();
    boolean isConstant();


    public static class LocalVariable<T extends Type<T>> implements Variable<T> {
        Identifier name;
        T type;
        Value<T> value;
        boolean isFinal;
        boolean isConstant;
        boolean hasScope;

        public Identifier name() {
            return name;
        }
        @Override
        public T type() {
            return type;
        }
        @Override
        public Value<T> getValue() {
            return value;
        }
        @Override
        public boolean isFinal() {
            return isFinal;
        }
        @Override
        public boolean isConstant() {
            return isConstant;
        }
    }
    public static class GlobalVariable<T extends Type<T>> implements Variable<T> {
        Identifier name;
        T type;
        Value<T> value;
        boolean isFinal;
        boolean isConstant;
        

        public Identifier name() {
            return name;
        }
        @Override
        public T type() {
            return type;
        }
        @Override
        public Value<T> getValue() {
            return value;
        }
        @Override
        public boolean isFinal() {
            return isFinal;
        }
        @Override
        public boolean isConstant() {
            return isConstant;
        }
    }
}