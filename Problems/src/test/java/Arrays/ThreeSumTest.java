package Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumTest {
    @Test
    public void TwoSumTest() {
        var sut = new ThreeSum();
        var input = new int[]{ -1, 0, 1, 2, -1, -4 }; // -4, -1, -1, 0, 1, 2
        var result = sut.threeSum(input);

        var expectedResult = new ArrayList<ArrayList<Integer>>();
        expectedResult.add(new ArrayList(Arrays.asList(-1, -1, 2)));
        expectedResult.add(new ArrayList(Arrays.asList(-1, 0, 1)));
        Assert.assertEquals( expectedResult, result );

        input = new int[]{ 0, 0, 0, 0 };
        result = sut.threeSum(input);
        expectedResult = new ArrayList<ArrayList<Integer>>();
        expectedResult.add(new ArrayList(Arrays.asList(0, 0, 0)));
        Assert.assertEquals( expectedResult, result );

        input = new int[]{ -1,0,1,2,-1,-4,-2,-3,3,0,4 };
        result = sut.threeSum(input);
        expectedResult = new ArrayList<ArrayList<Integer>>();
        //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]

        expectedResult.add(new ArrayList(Arrays.asList(-4, 0, 4)));
        expectedResult.add(new ArrayList(Arrays.asList(-4, 1, 3)));
        expectedResult.add(new ArrayList(Arrays.asList(-3, -1, 4)));
        expectedResult.add(new ArrayList(Arrays.asList(-3, 0, 3)));
        expectedResult.add(new ArrayList(Arrays.asList(-3, 1, 2)));
        expectedResult.add(new ArrayList(Arrays.asList(-2, -1, 3)));
        expectedResult.add(new ArrayList(Arrays.asList(-2, 0, 2)));
        expectedResult.add(new ArrayList(Arrays.asList(-1, -1, 2)));
        expectedResult.add(new ArrayList(Arrays.asList(-1, 0, 1)));
        Assert.assertEquals( expectedResult, result );

    }
}
