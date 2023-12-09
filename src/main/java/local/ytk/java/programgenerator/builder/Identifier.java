package local.ytk.java.programgenerator.builder;

public interface Identifier {
    public Identifier name();
    public String getString();        
    public static Identifier create(String name) {
        return new NamedIdentifier(name);
    }
    
    public static class NamedIdentifier implements Identifier {
        protected final String name;
        public NamedIdentifier(String name) {
            this.name = name;
        }
        
        @Override
        public NamedIdentifier name() {
            return this;
        }
        @Override
        public String toString() {
            return name;
        }
        @Override
        public String getString() {
            return name;
        }
    }
}
