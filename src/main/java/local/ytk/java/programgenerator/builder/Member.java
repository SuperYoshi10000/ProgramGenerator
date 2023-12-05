package local.ytk.java.programgenerator.builder;

public abstract class Member<T extends Type<T>> {
    protected final Identifier name;
    protected final Type<T> type;
    protected boolean isFinal = false;
    protected boolean isConstant = false;
    protected boolean isStatic = false;
    protected Visibility visibility = Visibility.PACKAGE_PRIVATE;

    public Member(Identifier name, T type) {
        super();
        this.name = name;
        this.type = type;
    }

    public static class Field<T extends Type<T>> extends Member<T> {
        public Field(Identifier name, T type) {
            super(name, type);
        }
        Value<T> value;
    }

    protected Member<T> setConstant(boolean isConstant) {
        this.isConstant = isConstant;
        return this;
    }
    protected Member<T> setFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }
    protected Member<T> setStatic(boolean isStatic) {
        this.isStatic = isStatic;
        return this;
    }
    protected Member<T> setVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public static enum Visibility {
        PUBLIC,
        PROTECTED,
        PACKAGE_PRIVATE,
        PRIVATE,
        ;
    }
}
