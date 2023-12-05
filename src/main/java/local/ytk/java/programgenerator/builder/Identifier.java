package local.ytk.java.programgenerator.builder;

public interface Identifier {
    public String name();
    public static Identifier create(String name) {
        return new NamedIdentifier(name);
    }
    
    public static class NamedIdentifier implements Identifier {
        protected final String name;
        public NamedIdentifier(String name) {
            this.name = name;
        }
        @Override
        public String name() {
            return name;
        }
    }
}
