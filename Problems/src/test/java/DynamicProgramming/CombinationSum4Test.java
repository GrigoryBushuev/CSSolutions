package DynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class CombinationSum4Test {

    @Test
    public void combinationSum4_returnsExpectedResult() {
        var sut = new CombinationSum4();
        var result = sut.combinationSum4(new int[] { 1, 2, 3 }, 4);
        Assert.assertEquals(7, result);

        result = sut.combinationSum4(new int[] { 9 }, 3);
        Assert.assertEquals(0, result);
    }

}