package Arrays.TwoPointers;

/*643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:
n == nums.length
1 <= k <= n <= 10^5
-10^4 <= nums[i] <= 10^4

Intuition: Max avg actually means that we need to find max running total of size k and divide by k.
We are going to iterate over the array and calculate running total of size k and compare it with previously found result.
Catch:
1. To avoid integer overflow we're going to keep running total in long.
2. We need to cast to double to avoid losing the remainder

Time complexity: O(n). We iterate over the array only once.
Space complexity: O(1). We allocate memory for local variables.
*/
public class MaxAverageSubArrayI {
    public double findMaxAverage(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE, curSum = 0;
        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            if (right - k >= 0) {
                curSum -= nums[right - k];
            }
            if (right + 1 - k >= 0) {
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return (double)maxSum / k;
    }
}
