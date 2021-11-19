package Recursion;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        var result = new LinkedList<List<Integer>>();
        getCombinations(n, k, 1, new LinkedList<Integer>(), result);
        return result;
    }

    private static void getCombinations(int n, int k, int startIndex, LinkedList<Integer> current, LinkedList<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new LinkedList(current));
            return;
        }
        for (var i = startIndex; i <=  n; i++) {
            current.add(i);
            getCombinations(n, k, i + 1, current, result);
            current.removeLast();
        }
    }
}
