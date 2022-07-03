package Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumTest {
    @Test
    public void TwoSumTest() {
        var input = new int[]{ -1,0,1,2,-1,-4 };
        var sut = new ThreeSum();
        var result = sut.threeSum(input);

        var expectedResult = new ArrayList<ArrayList<Integer>>();
        expectedResult.add(new ArrayList(Arrays.asList(-1, 0, 1)));
        expectedResult.add(new ArrayList(Arrays.asList(-1, -1, 2)));
        Assert.assertEquals( expectedResult, result );
    }
}
