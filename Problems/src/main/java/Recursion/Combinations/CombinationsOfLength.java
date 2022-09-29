package Recursion.Combinations;

import java.util.*;

public class CombinationsOfLength {
    public static List<List<Character>> getCombinationsOfLength(char[] arr, int length) {
        List<List<Character>> result = new LinkedList<>();
        getCombinationsOfLength(0, arr, length, new LinkedList<>(), result);
        return result;
    }

    private static void getCombinationsOfLength(int index, char[] arr, int length, List<Character> current, List<List<Character>> result) {
        if (current.size() == length) {
            result.add(current);
            return;
        }
        if (index == arr.length) {
            return;
        }
        getCombinationsOfLength(index + 1, arr, length, current, result);
        var toInclude = new LinkedList<>(current);
        toInclude.add(arr[index]);
        getCombinationsOfLength(index + 1, arr, length, toInclude, result);
    }
}
