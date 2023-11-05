package Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesSortedArrayTest {

    @Test
    public void removeDuplicates() {
        var sut = new RemoveDuplicatesSortedArray();
        var nums = new int[] { 1,1,2 };
        var res = sut.removeDuplicates(nums);
        var expectedNums = new int[] { 1, 2 };
        for (int i = 0; i < res; i++) {
            assert nums[i] == expectedNums[i];
        }

        nums = new int[]  { 0,0,1,1,1,2,2,3,3,4 };
        res = sut.removeDuplicates(nums);
        expectedNums = new int[] { 0, 1, 2, 3, 4 };
        for (int i = 0; i < res; i++) {
            assert nums[i] == expectedNums[i];
        }

    }
}