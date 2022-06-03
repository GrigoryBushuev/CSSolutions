package Arrays;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RepetitveNumberTest {

    @Test
    public void findRepetitiveNumberTest()
    {
        var input = new int[]{ 3,1,3,4,2 };
        var sut = new RepetitiveNumber();
        Assert.assertEquals(3, sut.findRepetitiveNumber(input));
    }
}
