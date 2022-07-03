package Arrays;

import java.util.*;

/*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Example 2:

    Input: nums = []
    Output: []
    Example 3:

    Input: nums = [0]
    Output: []

Constraints:
    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105
*/
public class ThreeSum {

    private static Integer[] sort3Values(int a, int b, int c) {
        Integer first, second, third = null;
        if (a < b) {
            if (b < c) {
                first  = a;
                second = b;
                third = c;
            } else if (a < c) {
                first = a;
                second = c;
                third = b;
            } else {
                first = c;
                second = a;
                third = b;
            }
        } else {
            if (a < c) {
                first = b;
                second = a;
                third = c;
            } else if (b < c) {
                first = b;
                second = c;
                third = a;
            } else {
                first = c;
                second = b;
                third = a;
            }
        }
        return new Integer[] { first, second, third };
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        var resultSet = new HashSet<List<Integer>>();
        var allNums = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var target = nums[i];
            for (var j = 0; j < nums.length; j++) {
                if (i == j) continue;
                var expectedValue = 0 - (nums[j] + target);
                var valueIndex = allNums.get(expectedValue);
                if (valueIndex != null && j > i && !(valueIndex == j || valueIndex == i)) {
                    var resultToAdd = Arrays.asList(sort3Values(target, nums[j], expectedValue));
                    if (!resultSet.contains(resultToAdd)){
                        resultSet.add(resultToAdd);
                    }
                }
                allNums.put(nums[j], j);
            }
        }
        return new ArrayList<>(resultSet);
    }
}
