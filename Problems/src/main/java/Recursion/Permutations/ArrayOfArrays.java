package Recursion.Permutations;
import java.util.*;

/*
Array of Arrays.
Given a 2-dimensional array, find all the different 1 dimensional arrays that you can make by selecting a single element
from each array.
eg.
arrayOfArrays({{1,2}, {3}, {4,5}}) =
{{1,3,4}, {1,3,5}, {2,3,4}, {2,3,5}}
*/
public class ArrayOfArrays {

    public static List<List<Integer>> arrayOfArrays(int[][] arr) {
        LinkedList result = new LinkedList<>();
        getArrayOfArrays(arr, 0, new LinkedList<Integer>(), result);
        return result;
    }

    public static List<List<Integer>> arrayOfArraysIterative(int[][] arr) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> temp = new LinkedList<>(result);
            result.clear();
            final int tempSize = temp.size();
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < tempSize; k++) {
                    var res = new LinkedList<>(temp.get(k));
                    res.add(arr[i][j]);
                    result.add(res);
                }
            }
        }
        return result;
    }

    private static void getArrayOfArrays(int[][] arr, int level, LinkedList<Integer> path, LinkedList result) {
        if (level == arr.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < arr[level].length; i++) {
            path.add(arr[level][i]);
            getArrayOfArrays(arr, level + 1, path, result);
            path.removeLast();
        }
    }
}
