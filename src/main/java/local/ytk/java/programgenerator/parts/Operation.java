package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public abstract class Operation extends ProgramPartType<Operation> {
    public Operation(String name) {
        super(name);
    }
    public static abstract class ORef extends Ref<Operation> {
        public ORef(Operation t) {
            super(t);
        }
    }
    public static class SingleOp extends Operation {
        public SingleOp(String name) {
            super(name);
        }
        public static class O1Ref extends Ref<Operation.SingleOp> {
            public O1Ref(Operation.SingleOp t, Ref<Statement> arg) {
                super(t);
                this.arg = arg;
            }
            public final Ref<Statement> arg;
        }
    }
    public static class DoubleOp extends Operation {
        public DoubleOp(String name) {
            super(name);
        }
        public static class O2Ref extends Ref<Operation.DoubleOp> {
            public O2Ref(Operation.DoubleOp t, Ref<Statement> arg1, Ref<Statement> arg2) {
                super(t);
                this.arg1 = arg1;
                this.arg2 = arg2;
            }
            public final Ref<Statement> arg1, arg2;
        }
    }
    public static class TripleOp extends Operation {
        public TripleOp(String name) {
            super(name);
        }
        public static class O3Ref extends Ref<Operation.TripleOp> {
            public O3Ref(Operation.TripleOp t, Ref<Statement> arg1, Ref<Statement> arg2, Ref<Statement> arg3) {
                super(t);
                this.arg1 = arg1;
                this.arg2 = arg2;
                this.arg3 = arg3;
            }
            public final Ref<Statement> arg1, arg2, arg3;
        }
    }
}
