package local.ytk.java.programgenerator.old.parts;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.google.common.collect.ImmutableMap;

import local.ytk.java.programgenerator.old.parts.Builder.BRef;
import local.ytk.java.programgenerator.old.parts.Builder.ERef;
import local.ytk.java.programgenerator.old.parts.Builder.OpRef;
import local.ytk.java.programgenerator.old.parts.Builder.Ref;
import local.ytk.java.programgenerator.old.parts.Name.NRef;
import local.ytk.java.programgenerator.old.parts.Operation.*;
import local.ytk.java.programgenerator.old.parts.ProgramPartType.*;
import local.ytk.java.programgenerator.old.parts.Type.TRef;

public abstract class ProgramGeneratorFunction<T extends ProgramPartType<?>>
implements BiFunction<Ref<T>, ImmutableMap<String, ProgramGeneratorFunction<T>.ProgramGeneratorArgument>, String> {
    public String generate(Ref<T> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
        return apply(t, arg);
    }

    public class ProgramGeneratorArgument {
        public final String name;
        public final T value;

        public ProgramGeneratorArgument(String name, T value) {
            this.name = name;
            this.value = value;
        }
    }


    public static abstract class ProgramActionGenerator extends ProgramGeneratorFunction<Action> {
        public static ProgramActionGenerator of(
            BiFunction<Ref<Action>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramActionGenerator() {
                @Override
                public String apply(Ref<Action> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramAnnotationGenerator extends ProgramGeneratorFunction<Annotation> {
        public static ProgramAnnotationGenerator of(
            BiFunction<Ref<Annotation>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramAnnotationGenerator() {
                @Override
                public String apply(Ref<Annotation> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramCodeGenerator extends ProgramGeneratorFunction<Code> {
        public static ProgramCodeGenerator of(
            BiFunction<Ref<Code>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramCodeGenerator() {
                @Override
                public String apply(Ref<Code> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramCommentGenerator extends ProgramGeneratorFunction<Comment> {
        public static ProgramCommentGenerator of(
            BiFunction<Ref<Comment>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramCommentGenerator() {
                @Override
                public String apply(Ref<Comment> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramGetterGenerator extends ProgramGeneratorFunction<Getter> {
        public static ProgramGetterGenerator of(
            BiFunction<Ref<Getter>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramGetterGenerator() {
                @Override
                public String apply(Ref<Getter> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramKeywordGenerator extends ProgramGeneratorFunction<Keyword> {
        public static ProgramKeywordGenerator of(
            BiFunction<Ref<Keyword>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramKeywordGenerator() {
                @Override
                public String apply(Ref<Keyword> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramNameGenerator extends ProgramGeneratorFunction<Name> {
        public static ProgramNameGenerator of(
            BiFunction<Ref<Name>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramNameGenerator() {
                @Override
                public String apply(Ref<Name> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
        public static final ProgramNameGenerator TOSTRING = new ProgramNameGenerator() {
            @Override
            public String apply(Ref<Name> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                return t instanceof NRef r ? r.name : "";
            }
        };
    }

    public static abstract class ProgramSingleOpGenerator extends ProgramGeneratorFunction<SingleOp> {
        public static ProgramSingleOpGenerator of(
            BiFunction<Ref<SingleOp>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramSingleOpGenerator() {
                @Override
                public String apply(Ref<SingleOp> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramDoubleOpGenerator extends ProgramGeneratorFunction<DoubleOp> {
        public static ProgramDoubleOpGenerator of(
            BiFunction<Ref<DoubleOp>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramDoubleOpGenerator() {
                @Override
                public String apply(Ref<DoubleOp> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramTripleOpGenerator extends ProgramGeneratorFunction<TripleOp> {
        public static ProgramTripleOpGenerator of(
            BiFunction<Ref<TripleOp>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramTripleOpGenerator() {
                @Override
                public String apply(Ref<TripleOp> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }

    public static abstract class ProgramStatementGenerator extends ProgramGeneratorFunction<Statement> {
        public static ProgramStatementGenerator of(
            BiFunction<Ref<Statement>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramStatementGenerator() {
                @Override
                public String apply(Ref<Statement> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramTypeGenerator extends ProgramGeneratorFunction<Type> {
        public static ProgramTypeGenerator of(
            BiFunction<Ref<Type>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramTypeGenerator() {
                @Override
                public String apply(Ref<Type> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
        public static final ProgramTypeGenerator TOSTRING = new ProgramTypeGenerator() {
            @Override
            public String apply(Ref<Type> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                return t instanceof TRef r ? r.name.name : "";
            }
        };
    }
    public static abstract class ProgramValueGenerator extends ProgramGeneratorFunction<Value> {
        public static ProgramValueGenerator of(
            BiFunction<Ref<Value>, ImmutableMap<String, ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramValueGenerator() {
                @Override
                public String apply(Ref<Value> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }

    public static abstract class ProgramOpGenerator<T extends O<?>> extends ProgramGeneratorFunction<T> {
        public static <T1 extends O<?>> ProgramOpGenerator<T1> of(
            BiFunction<Ref<T1>, ImmutableMap<String, ProgramGeneratorFunction<T1>.ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramOpGenerator<T1>() {
                @Override
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(ProgramGeneratorFunction<T> a) {
            return of(a, UnaryOperator.identity(), "");
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(
            ProgramGeneratorFunction<T> a, UnaryOperator<String> exists
        ) {
            return of(a, exists, "");
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(
            ProgramGeneratorFunction<T> a, String missing
        ) {
            return of(a, UnaryOperator.identity(), () -> missing);
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(
            ProgramGeneratorFunction<T> a, Supplier<String> missing
        ) {
            return of(a, UnaryOperator.identity(), missing);
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(
            ProgramGeneratorFunction<T> a, UnaryOperator<String> exists, String missing
        ) {
            return of(a, exists, () -> missing);
        }
        public static <T extends ProgramPartType<?>, T1 extends O<T>> ProgramOpGenerator<T1> of(
            ProgramGeneratorFunction<T> a, UnaryOperator<String> exists, Supplier<String> missing
        ) {
            return new ProgramOpGenerator<T1>() {
                @Override
                @SuppressWarnings("unchecked")
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    if (t instanceof OpRef r) {
                        return r.exists
                            ? exists.apply(a.apply(r.value, ImmutableMap.of()))
                            : missing.get();
                    } else return "";
                }
            };
        }
    }
    public static abstract class ProgramCpGenerator<T extends C<?>> extends ProgramGeneratorFunction<T> {
        public static <T1 extends C<?>> ProgramCpGenerator<T1> of(
            BiFunction<Ref<T1>, ImmutableMap<String, ProgramGeneratorFunction<T1>.ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramCpGenerator<T1>() {
                @Override
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
    }
    public static abstract class ProgramBothGenerator<T extends B<?, ?>> extends ProgramGeneratorFunction<T> {
        public static <T1 extends B<?, ?>> ProgramBothGenerator<T1> of(
            BiFunction<Ref<T1>, ImmutableMap<String, ProgramGeneratorFunction<T1>.ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramBothGenerator<T1>() {
                @Override
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
        public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>, T1 extends B<T, U>> ProgramBothGenerator<T1> of(
            ProgramGeneratorFunction<T> a, ProgramGeneratorFunction<U> b, BinaryOperator<String> c
        ) {
            return new ProgramBothGenerator<T1>() {
                @Override
                @SuppressWarnings("unchecked")
                public String apply(Ref<T1> x, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    if (x instanceof BRef r) {
                        return c.apply(a.apply(r.first, ImmutableMap.of()), b.apply(r.second, ImmutableMap.of()));
                    } else return "";
                }
            };
        }
    }
    public static abstract class ProgramEitherGenerator<T extends E<?, ?>> extends ProgramGeneratorFunction<T> {
        public static <T1 extends E<?, ?>> ProgramEitherGenerator<T1> of(
            BiFunction<Ref<T1>, ImmutableMap<String, ProgramGeneratorFunction<T1>.ProgramGeneratorArgument>, String> a
        ) {
            return new ProgramEitherGenerator<T1>() {
                @Override
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    return a.apply(t, arg);
                }
            };
        }
        public static <T extends ProgramPartType<?>, U extends ProgramPartType<?>, T1 extends E<T, U>> ProgramEitherGenerator<T1> of(
            ProgramGeneratorFunction<T> a, ProgramGeneratorFunction<U> b, UnaryOperator<String> isA, UnaryOperator<String> isB
        ) {
            return new ProgramEitherGenerator<T1>() {
                @Override
                @SuppressWarnings("unchecked")
                public String apply(Ref<T1> t, ImmutableMap<String, ProgramGeneratorArgument> arg) {
                    if (t instanceof ERef r) {
                        return r.isFirst
                            ? isA.apply(b.apply(r.first, ImmutableMap.of()))
                            : isB.apply(a.apply(r.second, ImmutableMap.of()));
                    } else return "";
                }
            };
        }
    }
}
