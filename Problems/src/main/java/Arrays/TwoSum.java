package Arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var valuesIndices = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var expectedValue = target - nums[i];
            var value = valuesIndices.get(expectedValue);
            if (value != null) {
                return new int[] { i, value };
            }
            valuesIndices.put(nums[i], i);
        }
        return null;
    }
}
