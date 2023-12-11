package local.ytk.java.programgenerator.builder;

import java.util.Arrays;
import java.util.List;

public class Method<T extends Type<T>> extends Member<T> {
    public final List<Action<?>> actions;

    public Method(Identifier name, T type, Action<?>... actions) {
        super(name, type);
        this.actions = List.of(actions);
    }

    public static class Constructor<T extends Type<T>> extends Method<T> {
        public Constructor(T type, Action<?>... actions) {
            super(type, type, actions);
        }
    }

    public static class Call<T extends Type<T>, V extends HasValue<T>, A extends Arguments<?, ?, ?>, U extends Type<U>, R extends HasValue<U>>
    implements Action<T> {
        public final T type;
        public final V value;
        public final A args;
        public final U returnType;
        public final R returnValue;

        public Call(V value, A args, R returnValue) {
            this.type = value.type();
            this.value = value;
            this.args = args;
            this.returnType = returnValue.type();
            this.returnValue = returnValue;
        }
    }

    public static class Arguments<T extends Type<T>, V extends Value<T>, A extends Arguments<?, ?, ?>> {
        protected final T type;
        protected V value;
        protected boolean exists = true;
        protected final A next;
        public Arguments(V value) {
            this.type = value.type();
            this.value = value;
            this.next = null;
        }
        public Arguments(V value, A next) {
            this.type = value.type();
            this.value = value;
            this.next = next;
        }
        

        public static class Optional<T extends Type<T>, V extends Value<T>, A extends Arguments<?, ?, ?>> extends Arguments<T, V, A> {
            public Optional() {
                super(null);
                exists = false;
            }
            public Optional(V value) {
                super(value);
            }
            public Optional(V value, A next) {
                super(value, next);
            }
        }
        public static class Multiple<T extends Type<T>, V extends Value<T>> extends Arguments<T, V, Arguments<?, ?, ?>> {
            @SafeVarargs
            public Multiple(V... value) {
                super(value[0]);
            }
            @SafeVarargs
            public static <T extends Type<T>, V extends Value<T>> Multiple<T, V> genNext(V... value) {
                return new Multiple<>(Arrays.copyOfRange(value, 1, value.length));
            }
        }
    }
}