package Recursion.Combinations;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void LongestIncreasingSubsequenceTest() {
        var sut = new LongestIncreasingSubsequence();
        int result;
        result = sut.lengthOfLIS(new int[] { 10,9,2,5,3,7,101,18 });
        Assert.assertEquals(4, result);
        result = sut.lengthOfLIS(new int[] { 0,1,0,3,2,3 });
        Assert.assertEquals(4, result);
        result = sut.lengthOfLIS(new int[] { 7,7,7,7,7,7,7 });
        Assert.assertEquals(1, result);
    }

}
