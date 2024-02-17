package local.ytk.tools.programgen2._impl;

public class Identifier implements local.ytk.tools.programgen2.parts.Identifier {
    public Identifier(String name) {
        this.name = name;
    }
    public final String name;
    public String name() {
        return name;
    }

    @Override
    public String generate() {
        return name;
    }
}
