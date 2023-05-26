package Recursion.Combinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
* 300. Longest Increasing Subsequence
*
* Given an integer array nums, return the length of the longest strictly increasing
subsequence

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return getMaxIncreasingSubsequence(nums, 0, new LinkedList<Integer>());
    }

    private static int getMaxIncreasingSubsequence(int[] nums, int currentIndex, LinkedList<Integer> currentRes) {
        if (currentIndex == nums.length) {
            return currentRes.size();
        }
        var excludedMax = getMaxIncreasingSubsequence(nums, currentIndex + 1, currentRes);
        var includeList = new LinkedList<>(currentRes);
        if (includeList.size() == 0 || nums[currentIndex] > includeList.getLast()) {
            includeList.add(nums[currentIndex]);
        }
        var includedMax = getMaxIncreasingSubsequence(nums, currentIndex + 1, includeList);
        return Math.max(excludedMax, includedMax);
    }
}
