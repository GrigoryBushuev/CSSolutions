package Arrays.TwoPointers;

/* 209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Example 4:
Input: target = 11, nums = [1,2,3,4,5]
Output: 3

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
*/

/*
Solution:
We're going to use two pointers. Right pointer is going to scan from beginning till the end of the array.
We're going to calculate the sum of every element at the right pointer's position on every iteration. While total sum is more than target
 1. we're going calculate the distance between right pointer and left pointer and compare it with the previously calculated distance.
 2. decrease sum by the value of the element at the left pointer
 3. move left pointer to the right
If minLength has never been calculated we return 0;

Time complexity: O(n). Each element is visited at most twice.
Space complexity: O(1). Only constant space required for the variables
*/
public class MinSubArrayLen {
        public int minSubArrayLen(int target, int[] nums) {
            int minLength = Integer.MAX_VALUE;
            int left = 0, sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    minLength = Math.min(minLength, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
}
