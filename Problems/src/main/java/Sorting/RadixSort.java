package Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RadixSort {
    public int[] sort(int[] nums) {
        var partitionedBySign = Arrays.stream(nums).boxed().collect(Collectors.partitioningBy(n -> n < 0));
        var negativeNums = radixSort(partitionedBySign.get(true).stream().map(n -> Math.abs(n)).mapToInt(Integer::intValue).toArray());
        var positiveNums = radixSort(partitionedBySign.get(false).stream().mapToInt(Integer::intValue).toArray());
        var j = 0;
        for (var i = negativeNums.length - 1; i >= 0; i--) {
            nums[j++] = -negativeNums[i];
        }
        System.arraycopy(positiveNums, 0, nums, j, positiveNums.length);
        return nums;
    }

    private int[] radixSort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        var max = Arrays.stream(nums).max().getAsInt();
        var exp = 1;
        while (max / exp > 0) {
            nums = countingSort(nums, exp);
            exp *= 10;
        }
        return nums;
    }

    private int[] countingSort(int[] nums, int exp) {
        var range = new int[10];
        for (var num : nums) {
            range[(num / exp ) % 10]++;
        }
        for (var j = 1; j < 10; j++) {
            range[j] = range[j] + range[j - 1];
        }

        var temp = new int[nums.length];
        for (var k = nums.length - 1; k >= 0; k--) {
            var value = (nums[k] / exp) % 10;
            var position = range[value] - 1;
            temp[position] = nums[k];
            range[value]--;
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        return nums;
    }
}
