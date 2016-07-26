package com.china.gavin.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayUtil {

    public ArrayUtil() {
        //TODO do nothing.
    }

	public static int[] createArray(int initialCapacity) {
		int[] dataSet = new int[initialCapacity];
		for (int i = 0; i < initialCapacity; i++) {
			dataSet[i] = i + 2;
		}
		return dataSet;
	}


    public static boolean contains(Object objAry[], Object obj) {
        Object arr$[] = objAry;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            Object element = arr$[i$];
            if (element.equals(obj))
                return true;
        }

        return false;
    }

    public static ArrayList toArrayList(Object array[]) {
        ArrayList retList = new ArrayList(array.length);
        Object arr$[] = array;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            Object value = arr$[i$];
            retList.add(value);
        }

        return retList;
    }

    public static LinkedList toLinkedList(Object items[]) {
        LinkedList retList = new LinkedList();
        Object arr$[] = items;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            Object item = arr$[i$];
            retList.add(item);
        }

        return retList;
    }

    public static boolean isEmpty(Object arrays[]) {
        return arrays == null || arrays.length == 0;
    }

    public static Object[] clone(Object ary[]) {
        if (ary == null)
            return null;
        else
            return (Object[]) (Object[]) clone(((Object) (ary)).getClass().getComponentType(), ((Object) (ary)));
    }

    public static Object clone(Class componentType, Object ary) {
        if (ary == null)
            return null;
        else
            return clone(componentType, ary, 0, length(ary));
    }

    public static Object clone(Class componentType, Object ary, int startIndex, int len) {
        Object result = Array.newInstance(componentType, len);
        System.arraycopy(ary, startIndex, result, 0, len);
        return result;
    }

    public static Object[] concat(Object ary1[], Object ary2[]) {
        if (ary1 == null || ary1.length == 0)
            return ary2;
        if (ary2 == null || ary2.length == 0) {
            return ary1;
        } else {
            Object ary[] = (Object[]) (Object[]) Array.newInstance(((Object) (ary1)).getClass().getComponentType(),
                ary1.length + ary2.length);
            System.arraycopy(((Object) (ary1)), 0, ((Object) (ary)), 0, ary1.length);
            System.arraycopy(((Object) (ary2)), 0, ((Object) (ary)), ary1.length, ary2.length);
            return ary;
        }
    }

    public String[] toStringArray(Object objects[]) {
        if (objects == null)
            return null;
        String strings[] = new String[objects.length];
        for (int i = 0; i < strings.length; i++) {
            Object o = objects[i];
            strings[i] = o != null ? o.toString() : null;
        }

        return strings;
    }

    public static boolean equals(Object ary1, Object ary2) {
        if (ary1 == null)
            return ary2 == null;
        if (ary2 == null)
            return false;
        if (ary1.equals(ary2))
            return true;
        if (!ary1.getClass().isArray() || !ary2.getClass().isArray())
            return false;
        if (ary1.getClass().getComponentType() != ary2.getClass().getComponentType())
            return false;
        int len = length(ary1);
        if (len != length(ary2))
            return false;
        for (int i = 0; i < len; i++)
            if (!equals(Array.get(ary1, i), Array.get(ary2, i)))
                return false;

        return true;
    }

    public static int length(Object ary[]) {
        return ary != null ? ary.length : 0;
    }

    public static int length(Object ary) {
        return ary != null ? Array.getLength(ary) : 0;
    }

    public static boolean isNone(Object ary[]) {
        return ary == null || ary.length == 0;
    }

    public static boolean isNone(Object ary) {
        return ary == null || length(ary) == 0;
    }
}
