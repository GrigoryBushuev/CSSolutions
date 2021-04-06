package Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

*/
class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        int index = right;

        while (index >= 0) {
            if (left <= right && Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
}


