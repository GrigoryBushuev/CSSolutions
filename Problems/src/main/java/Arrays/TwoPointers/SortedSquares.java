package Arrays.TwoPointers;

/*977. Squares of a Sorted Array
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Example 3:
Input: nums = [-7,-3,-2,-1,0]
Output: [0,1,2,9,49]

Example 4:
Input: nums = [0,1,2,3,7]
Output: [0,1,2,9,49]

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

The main idea is to compare absolute values. The greatest elements are the edges 0 for negative value and n.length - 1 for positive values
We compare absolute values and square the biggest one.

Time complexity: O(n). We iterate each element of the array only once.
Space complexity: O(n) to store the result array.
*/
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 1) {
            result[0] = nums[0] * nums[0];
        }

        int right = nums.length - 1;
        int left = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}


