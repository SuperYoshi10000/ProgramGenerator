package local.ytk.java.programgenerator.builder;

import com.google.common.collect.ArrayListMultimap;

public class PClass extends Member<PClass> implements Type<PClass> {
    public final ArrayListMultimap<Identifier, Member.Field<?>> fields = ArrayListMultimap.create();

    public PClass() {
        super(null);
    }
    public PClass(Identifier className) {
        super(className);
        this.type = this;
    }

    @Override
    public Identifier name() {
        return name;
    }
    @Override
    public String getString() {
        return name.getString();
    }
    @Override
    public String toString() {
        return getString();
    }

    public PClass addClass(PClass cls) {
        return addClass(Visibility.IGNORE, cls, false, false, false);
    }
    public PClass addClass(Visibility visibility, PClass cls, boolean isStatic, boolean isFinal, boolean isConstant) {
        if (cls.name == null) throw new NullPointerException("Class name cannot be null");
        cls.visibility = visibility;
        cls.isStatic = isStatic;
        cls.isFinal = isFinal;
        cls.isConstant = isConstant;
        return this;
    }

    public <T extends Type<T>> PClass addField(Identifier name, T type) {
        return addField(name, type, Visibility.IGNORE, false, false, false);
    }
    public <T extends Type<T>> PClass addField(Identifier name, T type, Value<T> value) {
        return addField(name, type, value, Visibility.IGNORE, false, false, false);
    }
    public <T extends Type<T>> PClass addField(Identifier name, T type, Visibility visibility, boolean isStatic, boolean isFinal, boolean isConstant) {
        final Member.Field<T> field = new Member.Field<T>(name, type);
        field.visibility = visibility;
        field.isStatic = isStatic;
        field.isFinal = isFinal;
        field.isConstant = isConstant;
        fields.put(name, field);
        return this;
    }
    public <T extends Type<T>> PClass addField(Identifier name, T type, Value<T> value, Visibility visibility, boolean isStatic, boolean isFinal, boolean isConstant) {
        final Member.Field<T> field = new Member.Field<T>(name, type);
        field.visibility = visibility;
        field.isStatic = isStatic;
        field.isFinal = isFinal;
        field.isConstant = isConstant;
        field.value = value;
        fields.put(name, field);
        return this;
    }
    
    public <T extends Type<T>> PClass addMethod(Identifier name, T type, Object code) {
        return addMethod(name, type, Visibility.IGNORE, code, false, false, false);
    }
    public <T extends Type<T>> PClass addMethod(Identifier name, T type, Visibility visibility, Object code, boolean isStatic, boolean isFinal, boolean isConstant) {
        // T.O.D.O. add addMethod()
        return this;
    }
}
