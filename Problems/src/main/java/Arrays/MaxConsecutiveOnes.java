package Arrays;

/*
* Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
*
* Example 1:
* Input: nums = [1,0,1,1,0]
* Output: 4
*
* Example 2:
* Input: nums = [1,0,1,1,0,1]
* Output: 4
*
* Constraints:
* 1 <= nums.length <= 105
* nums[i] is either 0 or 1.
* Explanation: Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
*
* Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
*/
public class MaxConsecutiveOnes {
    private int getNextZeroIndex(int startIndex, int[] nums) {
        while (startIndex < nums.length && nums[startIndex] != 0) {
            startIndex++;
        }
        return startIndex;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int result = Integer.MIN_VALUE;
        int leftIndex = 0;

        while (leftIndex < nums.length) {
            var firstZeroIndex = getNextZeroIndex(leftIndex, nums);
            result = Math.max(result, firstZeroIndex - leftIndex);
            if (firstZeroIndex < nums.length) {
                var secondZeroIndex = getNextZeroIndex(firstZeroIndex + 1, nums);
                result = Math.max(result, secondZeroIndex - leftIndex);
                leftIndex = firstZeroIndex + 1;
            } else {
                break;
            }
        }
        return result;
    }
}
