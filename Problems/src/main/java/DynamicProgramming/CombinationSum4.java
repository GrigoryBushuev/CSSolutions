package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
377. Combination Sum IV

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
The test cases are generated so that the answer can fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

Example 2:
Input: nums = [9], target = 3
Output: 0

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000

Follow up: What if negative numbers are allowed in the given array? How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
*/
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        var cache = new int[target + 1];
        Arrays.fill(cache, Integer.MIN_VALUE);
        //return getCombinationsOfSumTopDown(nums, target, cache);
        return getCombinationsOfSumBottomUp(nums, cache);
    }

    private static int getCombinationsOfSumTopDown(int[] nums, int currentSum, int[] cache) {
        if (currentSum < 0) {
            return 0;
        }
        if (currentSum == 0) {
            return 1;
        }
        if (cache[currentSum] != Integer.MIN_VALUE) {
            return cache[currentSum];
        }
        int total = 0;
        for (var num : nums) {
            total += getCombinationsOfSumTopDown(nums, currentSum - num, cache);
        }
        cache[currentSum] = total;
        return total;
    }

    private static int getCombinationsOfSumBottomUp(int[] nums, int[] cache) {
//        int total = 0;
//        for (var num : nums) {
//            total +=
//        }
        return 0;
    }
}
