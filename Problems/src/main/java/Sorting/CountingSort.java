package Sorting;

import java.util.Arrays;

public class CountingSort {
    public int[] sort(int[] nums) {
        var minValue = Arrays.stream(nums).min().getAsInt();
        var maxValue = Arrays.stream(nums).max().getAsInt();

        var offset = -minValue;
        var range = new int[maxValue - minValue + 1];
        for (var num : nums) {
            range[num + offset]++;
        }

        for (var i = 1; i < range.length; i++) {
            range[i] = range[i] + range[i - 1];
        }

        var result = new int[nums.length];
        for (var r = nums.length - 1; r >= 0; r--) {
            var valueToFind = nums[r];
            var positionInSortedArray = range[valueToFind + offset] - 1;
            result[positionInSortedArray] = valueToFind;
            range[valueToFind + offset]--;
        }
        System.arraycopy(result, 0, nums, 0, result.length);
        return nums;
    }
}
