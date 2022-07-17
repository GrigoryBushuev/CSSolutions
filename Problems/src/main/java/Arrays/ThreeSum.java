package Arrays;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
    private static void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffle(int[] arr) {
        for (var i = arr.length - 1; i > 0; i--) {
            var r = ThreadLocalRandom.current().nextInt(i + 1);
            if (i == r) continue;
            swap(arr, i, r);
        }
    }

    public static void quicksort(int[] nums) {
        shuffle(nums);
        quicksort(nums, 0, nums.length - 1);
    }

    private static void quicksort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        var partitionIndex = getPartitionIndex(nums, lo, hi);
        quicksort(nums, lo, partitionIndex - 1);
        quicksort(nums, partitionIndex + 1, hi);
    }

    private static int getPartitionIndex(int[] nums, int lo, int hi) {
        var i = lo;
        var j = hi + 1;

        var partitionVal = nums[lo];
        while (true) {
            while (nums[++i] < partitionVal) { if (i == hi) break; }
            while (nums[--j] > partitionVal) { if (j == lo) break; }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        quicksort(nums);
        // -4, -1, -1, 0, 1, 2
        // -4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4
        var resultSet = new ArrayList<List<Integer>>();
        for (var i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            var target = -nums[i];
            var lo = i + 1;
            var hi = nums.length - 1;

            while (lo < hi) {
                var sum = nums[lo] + nums[hi];
                if (sum < target) {
                    lo++;
                }
                else if (sum > target) {
                    hi--;
                }
                else {
                    final Integer first = nums[i];
                    final Integer second = nums[lo];
                    final Integer third = nums[hi];
                    resultSet.add(new ArrayList<>() {{
                        add(first);
                        add(second);
                        add(third);
                    }});
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                }
            }
        }
        return resultSet;
    }
}
