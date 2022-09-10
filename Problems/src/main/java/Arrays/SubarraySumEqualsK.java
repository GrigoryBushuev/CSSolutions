package Arrays;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.valueOf;

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//        A subarray is a contiguous non-empty sequence of elements within an array.
//
//        Example 1:
//
//        Input: nums = [1,1,1], k = 2
//        Output: 2
//        Example 2:
//
//        Input: nums = [1,2,3], k = 3
//        Output: 2
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        -1000 <= nums[i] <= 1000
//        -107 <= k <= 107
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }
        var result = 0;
        var prefixSum = new HashMap<Integer, Integer>();
        prefixSum.put(0, 1);
        var iSum = 0;
        for (var i = 0; i < nums.length; i++) {
            iSum += nums[i];
            var cnt = prefixSum.getOrDefault(iSum - target, 0);
            result += cnt;
            prefixSum.put(iSum, prefixSum.getOrDefault(iSum, 0) + 1);
        }
        return result;
    }
}
