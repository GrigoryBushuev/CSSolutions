package DynamicProgramming;

/* 238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and WITHOUT USING THE DIVISION OPERATION.

 Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        var leftProducts = new int[nums.length];
        var rightProducts = new int[nums.length];
        var totalProductLeft = 1;
        var totalProductRight = 1;
        var endIndex = nums.length - 1;
        for (var i = 0; i < nums.length; i++) {
            totalProductLeft *= nums[i];
            leftProducts[i] = totalProductLeft;
            totalProductRight *= nums[endIndex - i];
            rightProducts[endIndex - i] = totalProductRight;
        }
        for (var j = 0; j < nums.length; j++) {
            if(j == 0) {
                result[j] = rightProducts[j + 1];
            }
            else if (j == nums.length - 1) {
                result[j] = leftProducts[j - 1];
            }
            else {
                result[j] = leftProducts[j - 1] * rightProducts[j + 1];
            }
        }
        return result;
    }
}
