package local.ytk.java.programgenerator.builder;

public interface HasValue<T extends Type<T>> {
    public Value<T> get();
    public T type();
}
