package Arrays.TwoPointers;

import java.util.LinkedList;


/*1004. Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

We're going to use two pointers. The left pointer indicates the beginning of subarray with ones or 'flipped' zeroes.
The right pointer is going to scan over the array of nums and check if element at the current index is zero.
If it's zero we add index of 'flipped' 0 to stack k times. If the stack is already has size of k we move left pointer to
indicate start of the new subarray.

Catch: Pay attention to the case when k is 0;

Time complexity: O(n). We iterate over the array of nums only once
Space complexity: O(k). We need to keep indexes of flipped zeroes.

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
0 <= k <= nums.length*/

public class MaxConsecutiveOnesKTimes {
    public int longestOnes(int[] nums, int k) {
        int maxNumberOfFlips = Integer.MIN_VALUE;
        LinkedList<Integer> flipIndexes = new LinkedList<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                if (k == 0) { //handle edge case when k = 0;
                    left = right + 1;
                } else {
                    if (flipIndexes.size() == k) {
                        int firstFlip = flipIndexes.removeFirst();
                        left = firstFlip + 1;
                    }
                    flipIndexes.add(right);
                }
            }
            maxNumberOfFlips = Math.max(maxNumberOfFlips, right - left + 1);
        }
        return maxNumberOfFlips;
    }
}
