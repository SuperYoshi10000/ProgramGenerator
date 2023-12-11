package local.ytk.java.programgenerator.builder;

import java.util.List;

public interface Variable<T extends Type<T>> extends HasValue<T>, Identifier {
    

    public static class GlobalVariable<T extends Type<T>> implements Variable<T> {
        public Value<T> value;
        public NamedIdentifier id;

        @Override
        public Value<T> get() {
            return value;
        }

        @Override
        public T type() {
            return value.type();
        }

        @Override
        public String name() {
            return id.name();
        }
        @Override
        public Identifier id() {
            return id;
        }

    }
    
    public static class Assignment<T extends Type<T>, V extends HasValue<T>> {
        public final T type;
        public final V value;
        public final List<Modifier<Assignment<?, ?>>> modifiers;
        @SafeVarargs
        public Assignment(T type, V value, Modifier<Assignment<?, ?>>... modifiers) {
            this.type = type;
            this.value = value;
            this.modifiers = List.of(modifiers);
        }
    }
}
