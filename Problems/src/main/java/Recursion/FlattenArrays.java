package Recursion;

import java.util.*;

public class FlattenArrays {
    public static<T> List<T> flattenIter(T[][] arr) {
        List<T> result = new LinkedList<T>();
        for (T[] inner : arr) {
            for (T val : inner) {
                result.add(val);
            }
        }
        return result;
    }

    private static<T> void flatten(T[][] arr, List<T> result, int i, int j) {
        if (i == arr.length) {
            return;
        }
        if (j == arr[i].length) {
            flatten(arr, result, i + 1, 0);
            return;
        }
        result.add(arr[i][j]);
        flatten(arr, result, i, j + 1);
    }

    public static<T> List<T> flatten(T[][] arr) throws IllegalArgumentException {
        if (arr == null) {
            throw new IllegalArgumentException("arr is null");
        }
        List<T> result = new LinkedList<T>();
        flatten(arr, result, 0, 0 );
        return result;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> result = flatten(new Integer[][] { {0, 1, 2}, {3}, {4, 5} });
        for (Integer val : result) {
            System.out.print(val + ";");
        }
    }
}
