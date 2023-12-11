package local.ytk.java.programgenerator.builder;

import local.ytk.java.programgenerator.builder.Variable.Assignment;

public class Modifier<M> {
    public final String name;
    public Modifier(String name) {
        this.name = name;
    }

    private static <M> Modifier<M> modifier(String name) {
        return new Modifier<>(name);
    }

    public static final Modifier<Assignment<?, ?>>
        VAR = modifier("var"),
        LET = modifier("let"),
        CONST = modifier("const"),
        FINAL = modifier("final");
    public static final Modifier<Assignment<? extends Value.Number<?>, ?>>
        UNSIGNED = modifier("unsigned"),
        SIGNED = modifier("signed");

    
}
