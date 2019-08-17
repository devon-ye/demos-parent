package org.devon.algorithm.sort;


/**
 * @author dewen.ye
 * @date 2019/1/21 23:57
 */
public abstract class AbstractSort {

    public static void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static <T> void exch(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static <T> boolean less(T v, T w) {
        Comparable vc = (Comparable) v;
       /* Comparable vw = (Comparable) w;*/
        return vc.compareTo(w) < 0;
    }

    public static <T> Object[] newTypeTArray(Class<T> clazzType, int length) {
        String typeName = clazzType.getSimpleName();
        switch (typeName) {
            case "Double[]":
                return new Double[length];
            case "Integer[]":
                return new Integer[length];
            case "Byte[]":
                return new Byte[length];
            case "Short[]":
                return new Short[length];
            case "Long[]":
                return new Long[length];
            case "Boolean[]":
                return new Boolean[length];
            case "Character[]":
                return new Character[length];
            case "String[]":
                return new String[length];
            case "Object[]":
                return new Object[length];
            default:
                throw new IllegalArgumentException("unsupported type");
        }

    }


}
