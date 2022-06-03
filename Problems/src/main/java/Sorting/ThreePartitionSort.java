package Sorting;

public class ThreePartitionSort {
    public void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        var left = 0;
        var right = nums.length - 1;

        var i = 0;
        while (true) {
            while (left < right && nums[left] == 0) {
                left++;
            }
            while (right > left && nums[right] == 2) {
                right--;
            }
            while (i < left || (i < nums.length && nums[i] == 1)) {
                i++;
            }
            if (i > right) {
                break;
            }
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
        }
    }
}
