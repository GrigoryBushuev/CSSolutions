package Arrays;

public class RepetitiveNumber {

    public int findRepetitiveNumber(int[] nums) {
        var fastPointer = nums[nums[0]];
        var slowPointer = nums[0];

        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }

        slowPointer = nums[0];
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }
}
