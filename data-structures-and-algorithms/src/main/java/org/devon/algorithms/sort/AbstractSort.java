package org.devon.algorithms.sort;


/**
 * @author dewen.ye
 * @date 2019/1/21 23:57
 */
public abstract class AbstractSort implements Sort {

    private static final String DOUBLE_ARRAY="Double[]";
    private static final String INTEGER_ARRAY="Integer[]";
    private static final String BYTE_ARRAY="Byte[]";
    private static final String SHORT_ARRAY="Short[]";
    private static final String LONG_ARRAY="Long[]";
    private static final String BOOLEAN_ARRAY="Boolean[]";
    private static final String CHARACTER_ARRAY="Character[]";
    private static final String OBJECT_ARRAY="Object[]";
    private static final String STRING_ARRAY="String[]";



    protected static <T> void exch(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    protected static <T> boolean less(T v, T w) {
        Comparable vc = (Comparable) v;
        return vc.compareTo(w) < 0;
    }

    protected static <T> Object[] newTypeTArray(Class<T> clazzType, int length) {
        String typeName = clazzType.getSimpleName();
        switch (typeName) {
            case DOUBLE_ARRAY:
                return new Double[length];
            case INTEGER_ARRAY:
                return new Integer[length];
            case BYTE_ARRAY:
                return new Byte[length];
            case SHORT_ARRAY:
                return new Short[length];
            case LONG_ARRAY:
                return new Long[length];
            case BOOLEAN_ARRAY:
                return new Boolean[length];
            case CHARACTER_ARRAY:
                return new Character[length];
            case STRING_ARRAY:
                return new String[length];
            case OBJECT_ARRAY:
                return new Object[length];
            default:
                throw new IllegalArgumentException("unsupported type "+typeName);
        }

    }


}
