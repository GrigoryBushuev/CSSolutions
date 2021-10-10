package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        var result = new ArrayList<List<Integer>>();
        getCombinations(n, k, 1, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void getCombinations(int n, int k, int currentIndex, int startIndex, ArrayList<Integer> current, ArrayList<List<Integer>> result) {
        if (currentIndex == k + 1) {
            result.add(current);
            return;
        }
        for (var i = startIndex; i <=  n; i++) {
            var newResult = new ArrayList<Integer>();
            newResult.addAll(current);
            newResult.add(i);
            getCombinations(n, k, currentIndex + 1, i + 1, newResult, result);
        }
    }

}
