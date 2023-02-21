package Recursion.Permutations;

/*
47. Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

import java.util.*;

/*
* The crux of the method to group repetitive numbers to reduce the branching factor.
* Then iterate over the grouped collection where we:
*       1. Exclude the current item from the iterated collection, if (number of grouped items is equal to 0 we just skip current iteration, otherwise reduce the number of the grouped item by 1)
*       2. Add the current item to the current path
*       3. Call the recursion without the excluded item and pass the current path as a parameter
* The recursion ends when all the options are exhausted. We add the final path with all the excluded items to the result set and exit from the method.
*       Then we backtrack to recover the state as it was before the current iteration:
*       1. Put the excluded item back to the place where it has been taken before
*       2. Remove the excluded item from the path
*


Time complexity:
    P(N,K) = N!/(N - k)!
    The worst case, is the case without repetition O(N!)

Space Complexity: O(N)
    First of all, we build a hash table out of the input numbers. In the worst case where each number is unique, we would need O(N) space for the table.
    Since we applied recursion in the algorithm which consumes some extra space in the function call stack, we would need another O(N) space for the recursion.
    During the exploration, we keep a candidate of permutation along the way, which takes yet another O(N).
    To sum up, the total space complexity would be O(N)+O(N)+O(N)=O(N).
    Note, we did not take into account the space needed to hold the results. Otherwise, the space complexity would become O(N⋅N!).
*/
public class UniquePermutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        for (var num : nums) {
            numCounts.computeIfPresent(num, (key, val) -> val + 1);
            numCounts.putIfAbsent(num, 1);
        }
        addPermutations(numCounts, nums.length, new LinkedList<>(), result);
        return result;
    }

    private static void addPermutations(HashMap<Integer, Integer> numCounts, int totalLength, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == totalLength) {
            //we need to make a deep copy of resulting permutations otherwise it will be cleaned up by backtracking
            result.add(new LinkedList<>(path));
            return;
        }
        for (var keyVal : numCounts.entrySet()) {
            var val = keyVal.getValue();
            if (val == 0) {
                continue;
            }
            numCounts.put(keyVal.getKey(), val - 1);
            path.addLast(keyVal.getKey());
            addPermutations(numCounts, totalLength, path, result);
            //backtrack
            numCounts.put(keyVal.getKey(), val);
            path.removeLast();
        }
    }
}
