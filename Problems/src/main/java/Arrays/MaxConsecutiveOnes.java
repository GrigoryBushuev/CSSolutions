package Arrays;

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
