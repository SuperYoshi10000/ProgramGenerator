package local.ytk.java.programgenerator.builder;

import javax.annotation.Nullable;

import com.google.common.collect.ArrayListMultimap;

public class PClass implements Type<PClass> {
    @Nullable
    public final Identifier className;
    public final ArrayListMultimap<Identifier, Member.Field<?>> fields = ArrayListMultimap.create();

    public PClass() {
        this.className = null;
    }
    public PClass(Identifier className) {
        this.className = className;
    }

    @Override
    public String name() {
        return className != null ? className.name() : null;
    }

    public static PClass pclass(Identifier className) {
        return new PClass();
    }

    public static PClass pclass() {
        return new PClass();
    }

    public <T extends Type<T>> Member.Field<T> field(Identifier name, T type, Value<T> value) {
        final Member.Field<T> field = new Member.Field<T>(name, type);
        field.value = value;
        return field;
    }
    
}
