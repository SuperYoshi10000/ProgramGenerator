package local.ytk.java.programgenerator.old.parts;

import local.ytk.java.programgenerator.old.parts.ProgramPartType.B;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.E;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.M;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.None;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.O;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.x2;

@SuppressWarnings("unused")
public class Common {
    public static class Generic
    extends B<Name, O<M<Generic>>> {
        protected Generic(String name, Name n) {
            super(name, n, null);
            subtypes[1] = new O<>("OptionalGenerics", new M<>("MultipleGenerics", this));
        }
    }
    public static class ClassMember
    extends E<E< B<B<M<Annotation>, M<Keyword>>, B<B<Type, Name>, O<Value>>>,  B<B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code>, B<M<Annotation>, M<Keyword>>> >, ClassMember> {
        protected ClassMember(String name,
                E<B<B<M<Annotation>, M<Keyword>>, B<B<Type, Name>, O<Value>>>, B<B<M<B<B<Type, Name>, O<E<E<None, Value>, None>>>>, Code>, B<M<Annotation>, M<Keyword>>>> m) {
            super(name, m, null);
            subtypes[1] = this;
        }
    } 
    
}
