package Arrays.TwoPointers;
import java.util.List;


/*
Recall finding the largest size k subarray sum of an integer array in Largest Subarray Sum. What if we dont need the largest sum among all subarrays of fixed size k, but instead, we want to find the length of the longest subarray with sum smaller than or equal to a target?

Given input nums = [1, 6, 3, 1, 2, 4, 5] and target = 10, then the longest subarray that does not exceed 10 is [3, 1, 2, 4], so the output is 4 (length of [3, 1, 2, 4]).
*/

/*
We are going to have 2 pointers, left and right. The right pointer is going to iterate over the list from 0 to the size of the list.
On each iteration we're going to add every element to the aggregated sum.
	If sum is greater than the target we decrease the sum by value at the left pointer and move the left pointer to the right.
The distance between right pointer and left pointer is going to be current distance. We're going to compare the max distance that was found so far
with the distance that we found on the current iteration.

The iteration ends when right pointer reaches the nums length. Where we return the max distance.
*/
public class LongestSubArray {
    public static int subarraySumLongest(List<Integer> nums, int target) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0, sum = 0;
        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);
            while (sum > target) {
                sum -= nums.get(left);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
