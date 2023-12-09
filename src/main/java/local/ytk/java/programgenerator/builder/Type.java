package local.ytk.java.programgenerator.builder;

public interface Type<T extends Type<T>> extends Identifier {
    @Override
    public default String getString() {
        return name().toString();
    }
}
