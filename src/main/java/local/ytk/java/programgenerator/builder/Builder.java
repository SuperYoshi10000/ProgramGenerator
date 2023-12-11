package local.ytk.java.programgenerator.builder;

import java.util.HashMap;

public class Builder {
    protected final HashMap<String, File> files = new HashMap<>();

    public Builder() {
        super();
    }

    String generate(Language lang) {
        return lang.generate(this);
    }
}
