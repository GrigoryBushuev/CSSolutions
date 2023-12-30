package HashTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
350. Intersection of Two Arrays II
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:
Q1. What if the given array is already sorted? How would you optimize your algorithm?
A1. Two pointers intersection to scan both array. Time complexity: O(n + m). Space complexity: O(n + m);

Q2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
A2. HashMap algorithm is better as we can use the smallest array to build the HashSet and scan only one the biggest array.

Q3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
A3. If we have enough memory to store the first array then we can use the HashMap approach to build HashMap from the first array then load data of the second array from disk sequentially.
	if we don't have enough memory we can build HashMap by loading ranges of the first array sequentially.
	or we can use external sort and load both arrays sequentially for scanning.

* */
public class IntersectionNonUnique {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smallest = nums1.length < nums2.length ? nums1 : nums2;
        int[] biggest = nums1.length < nums2.length ? nums2 : nums1;

        int []map = new int[1001];
        for (int k : smallest) {
            map[k] += 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int val : biggest) {
            if (map[val] > 0) {
                result.add(val);
                map[val] -= 1;
            }
        }
        return result.stream().mapToInt(r -> r).toArray();
    }

    public int[] intersectSortedArray(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        return result.stream().mapToInt(r -> r).toArray();
    }
}
