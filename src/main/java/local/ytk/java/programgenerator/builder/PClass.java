package local.ytk.java.programgenerator.builder;

import com.google.common.collect.ArrayListMultimap;

public class PClass extends Member<PClass> implements Type<PClass> {
    public final ArrayListMultimap<Identifier, Member.Field<?>> fields = ArrayListMultimap.create();

    public PClass() {
        super(null, null);
        type = this;
    }
    public PClass(Identifier className) {
        super(className, null);
        type = this;
    }
    public PClass create(Identifier className) {
        return new PClass(className);
    }

    public static PClass create() {
        return new PClass();
    }

    @Override
    public String name() {
        return name != null ? name.name() : null;
    }

    public <T extends Type<T>> Member.Field<T> field(Identifier name, T type, Value<T> value) {
        final Member.Field<T> field = new Member.Field<T>(name, type);
        field.value = value;
        return field;
    }
    
}
