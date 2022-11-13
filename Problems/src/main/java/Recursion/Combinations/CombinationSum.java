package Recursion.Combinations;
import java.util.*;

/*
* 39. Combination Sum
*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (candidates.length == 1) {
            if (candidates[0] == target) {
                result.add(new LinkedList<>() {{ add(candidates[0]); }});
            }
            return result;
        }
        getCombinationSum(candidates, target, 0, new LinkedList<>(), 0, result);
        return result;
    }

    private static boolean getCombinationSum(int[] candidates, int target, int index, List<Integer> current, int currentSum, List<List<Integer>> result) {
        if (index == candidates.length) {
            return false;
        }
        if (currentSum > target) {
            return false;
        }
        if (currentSum == target) {
            if (!result.contains(current)) {
                result.add(current);
            }
            return true;
        }
        getCombinationSum(candidates, target, index + 1, current, currentSum, result);
        var candidateSum = currentSum + candidates[index];
        var toAdd = new LinkedList<>(current);
        toAdd.add(candidates[index]);
        if (getCombinationSum(candidates, target, index, toAdd, candidateSum, result)) {
            return true;
        }
        if (getCombinationSum(candidates, target, index + 1, toAdd, candidateSum, result)) {
            return true;
        }
        return false;
    }
}
