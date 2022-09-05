package Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SubarraySumEqualsKTest {

    @Test
    public void SubarraySumEqualsKTest() {
        var sut = new SubarraySumEqualsK();
        var input = new int []  { 1, 1, 1 };
        var result = sut.subarraySum(input, 2);
        Assert.assertEquals(2, result);

        input = new int []  { 1, 2, 3 };
        result = sut.subarraySum(input, 3);
        Assert.assertEquals(2, result);

        input = new int []  { 3, 7, -4, -2, -1, 5 };
        result = sut.subarraySum(input, 3);
        Assert.assertEquals(3, result);

        input = new int []  { 1, 0, -1, 1 };
        result = sut.subarraySum(input, 0);
        Assert.assertEquals(4, result);

        input = new int []  { 1 };
        result = sut.subarraySum(input, 0);
        Assert.assertEquals(0, result);

        input = new int []  { -1, -1, 1 };
        result = sut.subarraySum(input, 0);
        Assert.assertEquals(1, result);
    }
}
