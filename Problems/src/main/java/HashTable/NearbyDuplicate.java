package HashTable;
import java.util.Set;
import java.util.HashSet;

/*
219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
*/

public class NearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i - k >= 0) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
