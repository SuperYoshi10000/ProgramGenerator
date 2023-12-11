package local.ytk.java.programgenerator.builder;

import java.util.function.Supplier;

public interface Value<T extends Type<T>> extends HasValue<T> {
    public static interface Number<T extends Type<T>> extends Value<T> {
        public boolean isSigned();
        public boolean isUnsigned();
    }

    public default <V extends Value<T>, A extends Method.Arguments<T, V, A>> V call(Method<T> method, A args, Supplier<V> sup) {
        return sup.get();
    }

    /*
     Byte
     Short
     Integer
     Long
     LongLong
     Float
     Double
     LongDouble
     Character
     Boolean
     String
*/
    public static interface Byte extends Number<Byte.ByteType> {
        public static final ByteType TYPE = new ByteType();
        @Override
        public default ByteType type() {
            return TYPE;
        }
        @Override
        public Byte get();
        public static class ByteType implements Type<ByteType> {
            public final NamedIdentifier NAME = new NamedIdentifier("byte");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Short extends Number<Short.ShortType> {
        public static final ShortType TYPE = new ShortType();
        @Override
        public default ShortType type() {
            return TYPE;
        }
        @Override
        public Short get();
        public static class ShortType implements Type<ShortType> {
            public final NamedIdentifier NAME = new NamedIdentifier("short");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Integer extends Number<Integer.IntegerType> {
        public static final IntegerType TYPE = new IntegerType();
        @Override
        public default IntegerType type() {
            return TYPE;
        }
        @Override
        public Integer get();
        public static class IntegerType implements Type<IntegerType> {
            public final NamedIdentifier NAME = new NamedIdentifier("int");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Long extends Number<Long.LongType> {
        public static final LongType TYPE = new LongType();
        @Override
        public default LongType type() {
            return TYPE;
        }
        @Override
        public Long get();
        public static class LongType implements Type<LongType> {
            public final NamedIdentifier NAME = new NamedIdentifier("long");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface LongLong extends Number<LongLong.LongLongType> {
        public static final LongLongType TYPE = new LongLongType();
        @Override
        public default LongLongType type() {
            return TYPE;
        }
        @Override
        public LongLong get();
        public static class LongLongType implements Type<LongLongType> {
            public final NamedIdentifier NAME = new NamedIdentifier("long long");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Float extends Number<Float.FloatType> {
        public static final FloatType TYPE = new FloatType();
        @Override
        public default FloatType type() {
            return TYPE;
        }
        @Override
        public Float get();
        public static class FloatType implements Type<FloatType> {
            public final NamedIdentifier NAME = new NamedIdentifier("float");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Double extends Number<Double.DoubleType> {
        public static final DoubleType TYPE = new DoubleType();
        @Override
        public default DoubleType type() {
            return TYPE;
        }
        @Override
        public Double get();
        public static class DoubleType implements Type<DoubleType> {
            public final NamedIdentifier NAME = new NamedIdentifier("double");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface LongDouble extends Number<LongDouble.LongDoubleType> {
        public static final LongDoubleType TYPE = new LongDoubleType();
        @Override
        public default LongDoubleType type() {
            return TYPE;
        }
        @Override
        public LongDouble get();
        public static class LongDoubleType implements Type<LongDoubleType> {
            public final NamedIdentifier NAME = new NamedIdentifier("long double");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Character extends Number<Character.CharacterType> {
        public static final CharacterType TYPE = new CharacterType();
        @Override
        public default CharacterType type() {
            return TYPE;
        }
        @Override
        public Character get();
        public static class CharacterType implements Type<CharacterType> {
            public final NamedIdentifier NAME = new NamedIdentifier("char");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface Boolean extends Value<Boolean.BooleanType> {
        public static final BooleanType TYPE = new BooleanType();
        @Override
        public default BooleanType type() {
            return TYPE;
        }
        @Override
        public Boolean get();
        public static class BooleanType implements Type<BooleanType> {
            public final NamedIdentifier NAME = new NamedIdentifier("boolean");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
    public static interface String extends Value<String.StringType> {
        public static final StringType TYPE = new StringType();
        @Override
        public default StringType type() {
            return TYPE;
        }
        @Override
        public String get();
        public static class StringType implements Type<StringType> {
            public final NamedIdentifier NAME = new NamedIdentifier("string");
            public java.lang.String name() {
                return NAME.name();
            }
        }
    }
/*
    public static interface $1 extends Value<$1.$1Type> {
        public static final $1Type TYPE = new $1Type();
        @Override
        public default $1Type type() {
            return TYPE;
        }
        @Override
        public $1 get();
        public static class $1Type implements Type<$1Type> {
            public final NamedIdentifier NAME = new NamedIdentifier("$1");
            public NamedIdentifier name() {
                return NAME;
            }
        }
    }
     */
}
