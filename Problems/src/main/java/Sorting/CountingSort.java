package Sorting;

import java.util.Optional;

public class CountingSort {
    public int[] sort(Optional<Integer> min, Optional<Integer> max, int[] nums) {
        var minValue = min.isPresent() ? min.get() : 0;
        var maxValue = max.isPresent() ? max.get() + 1 : nums.length;

        var range = new int[maxValue - minValue];
        for (var num : nums) {
            range[num]++;
        }
        var i = 0;
        for (var r = 0; r < range.length; r++) {
            while (range[r] > 0) {
                nums[i++] = r;
                range[r]--;
            }
        }
        return nums;
    }
}
