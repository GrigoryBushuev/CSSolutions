package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortedArrayToHeightBalancedBSTTest {

    @Test
    void sortedArrayToBST() {
        var sut = new SortedArrayToHeightBalancedBST();
        int[] nums = new int[] { -10,-3, 2, 0, 3, 5,9 };
        var result = sut.sortedArrayToBST(nums);
    }
}