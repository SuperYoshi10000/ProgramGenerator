package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Action.ARef;
import local.ytk.java.programgenerator.parts.Name.NRef;
import local.ytk.java.programgenerator.parts.ProgramPartType.B;
import local.ytk.java.programgenerator.parts.ProgramPartType.C;
import local.ytk.java.programgenerator.parts.ProgramPartType.E;
import local.ytk.java.programgenerator.parts.ProgramPartType.O;
import local.ytk.java.programgenerator.parts.Statement.SRef;

public class Builder {
    public static <T extends ProgramPartType<?>> Action.ARef make(Action t, String v) {
        return new Action.ARef(t, v);
    }
    public static <T extends ProgramPartType<?>> Annotation.AnRef make(Annotation t, NRef n) {
        return new Annotation.AnRef(t, n);
    }
    public static <T extends ProgramPartType<?>> Code.CRef make(Code t, ARef... a) {
        return new Code.CRef(t, a);
    }
    public static <T extends ProgramPartType<?>> Comment.CmRef make(Comment t, String c, boolean m, boolean d) {
        return new Comment.CmRef(t, c, m, d);
    }
    public static <T extends ProgramPartType<?>> Getter.GRef make(Getter t, NRef n) {
        return new Getter.GRef(t, n);
    }
    public static <T extends ProgramPartType<?>> Keyword.KRef make(Keyword t, NRef n) {
        return new Keyword.KRef(t, n);
    }
    public static <T extends ProgramPartType<?>> Name.NRef make(Name t, String v) {
        return new Name.NRef(t, v);
    }
    public static <T extends ProgramPartType<?>> Operation.SingleOp.O1Ref make(Operation.SingleOp t, SRef v) {
        return new Operation.SingleOp.O1Ref(t, v);
    }
    public static <T extends ProgramPartType<?>> Operation.DoubleOp.O2Ref make(Operation.DoubleOp t, SRef v1, SRef v2) {
        return new Operation.DoubleOp.O2Ref(t, v1, v2);
    }
    public static <T extends ProgramPartType<?>> Operation.TripleOp.O3Ref make(Operation.TripleOp t, SRef v1, SRef v2, SRef v3) {
        return new Operation.TripleOp.O3Ref(t, v1, v2, v3);
    }
    public static <T extends ProgramPartType<?>> Statement.SRef make(Statement t, String v) {
        return new Statement.SRef(t, v);
    }
    public static <T extends ProgramPartType<?>> Type.TRef make(Type t, NRef n) {
        return new Type.TRef(t, n);
    }
    public static <T extends ProgramPartType<?>> Value.VRef make(Value t, String v) {
        return new Value.VRef(t, v);
    }

    public static <T extends ProgramPartType<?>> CpRef<T> make(C<T> t, Ref<T> a) {
        return new CpRef<>(t, a);
    }
    public static <T extends ProgramPartType<?>> OpRef<T> make(O<T> t, Ref<T> a) {
        return new OpRef<>(t, a);
    }

    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> BRef<T, U> make(B<T, U> t, Ref<T> a, Ref<U> b) {
        return new BRef<>(t, a, b);
    }
    public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> ERef<T, U> make(E<T, U> t, Ref<T> a, Ref<U> b) {
        return new ERef<>(t, a, b);
    }

    public static abstract class Ref<T extends ProgramPartType<?>> {
        public final T type;
        public Ref(T t) {
            this.type = t;
        }
    }

    public static class CpRef<T extends ProgramPartType<?>> extends Ref<C<T>> {
        public final Ref<T> value;
        public CpRef(C<T> t, Ref<T> a) {
            super(t);
            this.value = a;
        }
    }
    public static class OpRef<T extends ProgramPartType<?>> extends Ref<O<T>> {
        public final Ref<T> value;
        public final boolean exists;
        public OpRef(O<T> t, Ref<T> a) {
            super(t);
            value = a;
            exists = true;
        }
        public OpRef(O<T> t) {
            super(t);
            value = null;
            exists = false;
        }
    }
    public static class BRef<T extends ProgramPartType<?>, U extends ProgramPartType<?>> extends Ref<B<T, U>> {
        public final Ref<T> first;
        public final Ref<U> second;
        public BRef(B<T, U> t, Ref<T> a, Ref<U> b) {
            super(t);
            this.first = a;
            this.second = b;
        }
    }
    public static class ERef<T extends ProgramPartType<?>, U extends ProgramPartType<?>> extends Ref<E<T, U>> {
        public final Ref<T> first;
        public final Ref<U> second;
        public final boolean isFirst;
        public final boolean isSecond;
        protected ERef(E<T, U> t, Ref<T> a, Ref<U> b) {
            super(t);
            this.first = a;
            this.second = b;
            this.isFirst = a != null;
            this.isSecond = b != null;
        }
        public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> ERef<T, U> first(E<T, U> t, Ref<T> a) {
            return new ERef<>(t, a, null);
        }
        public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>> ERef<T, U> second(E<T, U> t, Ref<U> b) {
            return new ERef<>(t, null, b);
        }
    }
}
