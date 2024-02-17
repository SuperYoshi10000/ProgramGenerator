package local.ytk.tools.programgen2.type;

public interface IntersectionType<A extends Type, B extends Type> extends Type {
    A asA();
    B asB();
}
