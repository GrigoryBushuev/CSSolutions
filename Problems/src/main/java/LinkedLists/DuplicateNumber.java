package LinkedLists;

/*
287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/
public class DuplicateNumber {

    /*
    * We're going to use the Floyd's algorithm for cycle detection
    * There are 2 pointers fast amd slow. The slow pointer is moving iteratively by index from 0 till n + 1.
    * The fast pointer is moving by indices where the next index is determined by the value of the item.*/
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length == 2) {
            return nums[0];
        }
        var fastPtr = nums[0];
        var slowPtr = nums[0];
        do {
            slowPtr = nums[slowPtr];
            fastPtr = nums[nums[fastPtr]];
        } while (slowPtr != fastPtr);

        slowPtr = nums[0];
        while (slowPtr != fastPtr) {
            slowPtr = nums[slowPtr];
            fastPtr = nums[fastPtr];
        }
        return slowPtr;
    }

    //{ 1, 3, 4, 2, 5, 2 }
    // i = 0, 1 -3 4 2 5 2
    // i = 1, 1 -3 4 -2 5 2
    // i = 2, 1 -3 4 -2 -5 2
    // i = 3, 1 -3 4 -2 -5 2
    public int findDuplicateWithNegativeMarking(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int absoluteVal = Math.abs(nums[i]);
            if (nums[absoluteVal] > 0) {
                nums[absoluteVal] *= -1;
            } else {
                result = absoluteVal;
            }
        }
        //rollback to original state
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return result;
    }
}
