package local.ytk.java.programgenerator.builder;

public interface Value<T extends Type<T>> extends HasValue<T> {
    public T type();

    public static interface Number<N extends Type<N>> extends Value<N> {
        @Override
        public N type();
    }
    public static interface Byte extends Number<Byte.ByteType> {
        public static final ByteType type = new ByteType();
        @Override
        public default ByteType type() {
            return type;
        }
        byte value();
        public static class ByteType implements Type<ByteType> {
            public final NamedIdentifier name = new NamedIdentifier("Byte");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Short extends Number<Short.ShortType> {
        public static final ShortType type = new ShortType();
        @Override
        public default ShortType type() {
            return type;
        }
        short value();
        public static class ShortType implements Type<ShortType> {
            public final NamedIdentifier name = new NamedIdentifier("Short");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Integer extends Number<Integer.IntegerType> {
        public static final IntegerType type = new IntegerType();
        @Override
        public default IntegerType type() {
            return type;
        }
        int value();
        public static class IntegerType implements Type<IntegerType> {
            public final NamedIdentifier name = new NamedIdentifier("Integer");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Long extends Number<Long.LongType> {
        public static final LongType type = new LongType();
        @Override
        public default LongType type() {
            return type;
        }
        long value();
        public static class LongType implements Type<LongType> {
            public final NamedIdentifier name = new NamedIdentifier("Long");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface LongLong extends Number<LongLong.LongLongType> {
        public static final LongLongType type = new LongLongType();
        @Override
        public default LongLongType type() {
            return type;
        }
        long value();
        public static class LongLongType implements Type<LongLongType> {
            public final NamedIdentifier name = new NamedIdentifier("LongLong");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Float extends Number<Float.FloatType> {
        public static final FloatType type = new FloatType();
        @Override
        public default FloatType type() {
            return type;
        }
        float value();
        public static class FloatType implements Type<FloatType> {
            public final NamedIdentifier name = new NamedIdentifier("Float");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Double extends Number<Double.DoubleType> {
        public static final DoubleType type = new DoubleType();
        @Override
        public default DoubleType type() {
            return type;
        }
        double value();
        public static class DoubleType implements Type<DoubleType> {
            public final NamedIdentifier name = new NamedIdentifier("Double");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface LongDouble extends Number<LongDouble.LongDoubleType> {
        public static final LongDoubleType type = new LongDoubleType();
        @Override
        public default LongDoubleType type() {
            return type;
        }
        double[] value();
        public static class LongDoubleType implements Type<LongDoubleType> {
            public final NamedIdentifier name = new NamedIdentifier("LongDouble");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Character extends Number<Character.CharType> {
        public static final CharType type = new CharType();
        @Override
        public default CharType type() {
            return type;
        }
        char value();
        public static class CharType implements Type<CharType> {
            public final NamedIdentifier name = new NamedIdentifier("LongDouble");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface Boolean extends Value<Boolean.BooleanType> {
        public static final BooleanType type = new BooleanType();
        @Override
        public default BooleanType type() {
            return type;
        }
        boolean value();
        public static class BooleanType implements Type<BooleanType> {
            public final NamedIdentifier name = new NamedIdentifier("Boolean");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    public static interface String extends Value<String.StringType> {
        public static final StringType type = new StringType();
        @Override
        public default StringType type() {
            return type;
        }
        char[] value();
        public static class StringType implements Type<StringType> {
            public final NamedIdentifier name = new NamedIdentifier("String");
            public NamedIdentifier name() {
                return name;
            }
        }
    }
    @Override
    java.lang.String toString();
}