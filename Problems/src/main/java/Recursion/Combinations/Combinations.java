package Recursion.Combinations;

import java.util.*;

/*
77. Combinations
* Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
*/
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
